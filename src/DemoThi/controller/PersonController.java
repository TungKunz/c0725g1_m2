package DemoThi.controller;

import DemoThi.entity.ElectricBill;
import DemoThi.entity.ForeignCustomer;
import DemoThi.entity.Person;
import DemoThi.entity.VietnameseCustomer;
import DemoThi.service.*;
import DemoThi.view.ElectricBillView;
import DemoThi.view.ForeignCustomerView;
import DemoThi.view.VietnameseCustomerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IVietnameseCustomerService<VietnameseCustomer> vietnameseCustomerService = new VietnameseCustomerService();
    private static final IForeignCustomerService<ForeignCustomer> foreignCustomerService = new ForeignCustomerService();
    private static final IElectricBillService<ElectricBill> electricBillService = new ElectricBillService();

    public static List<Person> findAllPerson() {
        List<Person> list = new ArrayList<>();
        list.addAll(vietnameseCustomerService.findAll());
        list.addAll(foreignCustomerService.findAll());
        return list;
    }

    public static void PersonManager() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1. Thêm mới khách hàng
                    2. Hiển thị thông tin khách hàng
                    3. Tìm kiếm khách hàng
                    4. Thêm hóa đơn
                    5. Chỉnh sửa hóa đơn
                    6. Hiển thị thông tin chi tiết hóa đơn
                    7. Thoát""");
            System.out.println("Nhập lựa chọn");
            int choise = 0;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không hợp lệ mời bạn nhập lại");
            }
            switch (choise) {
                case 1 -> creatCustomer();
                case 2 -> displayCustomer();
                case 3 -> searchName();
                case 4 -> creatElectricBill();
                case 5 -> editElectricBill();
                case 6 -> displayElectric();
                default -> flag = false;
            }
        }
    }

    private static void creatCustomer() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1. Thêm mới khách hàng việt nam
                    2. Thêm mới khách hàng nước ngoài
                    3. Thoát""");
            System.out.println("Nhập lựa chọn");
            int choise;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            switch (choise) {
                case 1 -> {
                    System.out.println("Thêm mới khách hàng việt nam");
                    VietnameseCustomer vietnameseCustomer = new VietnameseCustomer();
                    List<String> customerTypeList = vietnameseCustomerService.customerTypelist();
                    int choice = VietnameseCustomerView.customerType(customerTypeList);
                    String selectedType = customerTypeList.get(choice - 1);
                    VietnameseCustomerView.inputData("add", vietnameseCustomer, selectedType);
                    vietnameseCustomerService.add(vietnameseCustomer);
                    System.out.println("OK");
                }
                case 2 -> {
                    System.out.println("Thêm mới khách hàng nước ngoài");
                    ForeignCustomer foreignCustomer = new ForeignCustomer();
                    List<String> nationality = foreignCustomerService.nationalityList();
                    int choice = ForeignCustomerView.inputNationality(nationality);
                    String selectedType = nationality.get(choice - 1);
                    ForeignCustomerView.inputData("add", foreignCustomer, selectedType);
                    foreignCustomerService.add(foreignCustomer);
                    System.out.println("OK");
                }
                default -> flag = false;
            }
        }
    }

    private static void displayCustomer() {
        System.out.println("Hiển thị thông tin khách hàng");
        System.out.println("%-5s %-15s %-25s %-15s%n");
        List<Person> personList = findAllPerson();
        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + ". " + personList.get(i).toString());
        }
    }

    private static void searchName() {
        System.out.println("Tìm kiếm theo tên gần đúng");
        String name = scanner.nextLine();
        List<Person> list = new ArrayList<>();
        List<Person> personList = findAllPerson();
        for (Person person : personList) {
            if (person.getFullName().toLowerCase().contains(name.toLowerCase())) {
                list.add(person);
            }
        }
        if (list.isEmpty()) {
            System.out.println("Danh sách tìm kiếm trống");
        }
        for (Person person : list) {
            System.out.println(person);
        }
    }

    private static void creatElectricBill() {
        System.out.println("Thêm mới hóa đơn");
        System.out.println("-----------------");
        List<Person> personList = findAllPerson();
        int index;
        while (true){
            displayCustomer();
            System.out.println("Nhập stt khách hàng bạn muốn thêm hóa đơn");

            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index < 1 || index > personList.size()) {
                    System.out.println("Số thứ tự không hợp lệ!");
                }else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không hợp lệ");
            } catch (IndexOutOfBoundsException e){
                System.out.println("Bạn nhập số thứ tự không hợp lệ");
            }catch (Exception e){
                System.out.println("Lỗi");
            }
        }
        Person person = personList.get(index - 1);
        ElectricBill electricBill = new ElectricBill();
        ElectricBillView.inputData(electricBill);
        if (person instanceof VietnameseCustomer) {
            VietnameseCustomer vietnameseCustomer = vietnameseCustomerService.findById(person.getCustomId());
            double totalAmount = vietnameseCustomer.calculateTotalAmount(electricBill.getConsumedKW(), electricBill.getUnitPrice());
            electricBill.setCustomerId(person.getCustomId());
            electricBill.setTotalAmount(totalAmount);
            electricBillService.add(electricBill);
        } else {
            ForeignCustomer foreignCustomer = foreignCustomerService.findById(person.getCustomId());
            double totalAmount = foreignCustomer.calculateTotalAmount(electricBill.getConsumedKW(), electricBill.getUnitPrice());
            electricBill.setCustomerId(person.getCustomId());
            electricBill.setTotalAmount(totalAmount);
            electricBillService.add(electricBill);
        }
    }

    private static void displayElectric() {
        System.out.println("Danh sách hóa đơn");
        System.out.println("--------------------------------------------------");
        ElectricBillView.displayElectric(electricBillService.findAll());
    }

    private static void editElectricBill() {
        displayElectric();
        int index;
        int indexCustomer;
        List<Person> personList = findAllPerson();
        try {
            System.out.println("Nhập số thứ tự hóa đơn bạn muốn sửa: ");
            index = Integer.parseInt(scanner.nextLine());
            List<ElectricBill> electricBillList = electricBillService.findAll();

            if (index < 1 || index > electricBillList.size()) {
                System.out.println("Số thứ tự không hợp lệ!");
                return;
            }

            ElectricBill editElectric = electricBillList.get(index - 1);
            ElectricBill electric = ElectricBillView.inputData(editElectric);
            boolean check = electricBillService.editById(electric);
            if (check) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Cập nhật không thành công");
            }

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }
}
