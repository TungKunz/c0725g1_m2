package DemoThi.controller;

import DemoThi.entity.ElectricBill;
import DemoThi.entity.ForeignCustomer;
import DemoThi.entity.Person;
import DemoThi.entity.VietnameseCustomer;
import DemoThi.service.*;
import DemoThi.validate.CheckPerson;
import DemoThi.view.ElectricBillView;
import DemoThi.view.ForeignCustomerView;
import DemoThi.view.VietnameseCustomerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonController {
    private static final Scanner scanner= new Scanner(System.in);
    private static final IVietnameseCustomerService<VietnameseCustomer> vietnameseCustomerService=new VietnameseCustomerService();
    private static final IForeignCustomerService<ForeignCustomer> foreignCustomerService=new ForeignCustomerService();
    private static final IElectricBillService<ElectricBill> electricBillService=new ElectricBillService();
    public static void PersonManager(){
        boolean flag=true;
        while (flag){
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
            try{
                choise=Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bạn nhập không hợp lệ mời bạn nhập lại");
            }
            switch (choise){
                case 1 -> creatCustomer();
                case 2 -> displayCustomer();
                case 3-> searchName();
                case 4-> creatElectricBill();
                case 5-> editElectricBill();
                case 6-> displayElectric();
                default -> flag=false;
            }
        }
    }
    private static void creatCustomer(){
        boolean flag=true;
        while (flag){
            System.out.println("""
                    1. Thêm mới khách hàng việt nam
                    2. Thêm mới khách hàng nước ngoài
                    3. Thoát""");
            System.out.println("Nhập lựa chọn");
            int choise;
            try {
                choise=Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                continue;
            }
            switch (choise){
                case 1-> {
                    System.out.println("Thêm mới khách hàng việt nam");
                    VietnameseCustomer vietnameseCustomer = new VietnameseCustomer();
                    List<String> customerTypeList = vietnameseCustomerService.customerTypelist();
                    int choice = VietnameseCustomerView.customerType(customerTypeList);
                    String selectedType = customerTypeList.get(choice-1);
                    VietnameseCustomerView.inputData("add", vietnameseCustomer, selectedType);
                    vietnameseCustomerService.add(vietnameseCustomer);
                    System.out.println("OK");
                }
                case 2 -> {
                    System.out.println("Thêm mới khách hàng nước ngoài");
                    ForeignCustomer foreignCustomer=new ForeignCustomer();
                    List<String> nationality = foreignCustomerService.nationalityList();
                    int choice= ForeignCustomerView.inputNationality(nationality);
                    String selectedType = nationality.get(choice-1);
                    ForeignCustomerView.inputData("add",foreignCustomer,selectedType);
                    foreignCustomerService.add(foreignCustomer);
                    System.out.println("OK");
                }
                default -> flag=false;
            }
        }
    }
    private static void displayCustomer(){
        System.out.println("Hiển thị thông tin khách hàng");
        VietnameseCustomerView.displayInFor(vietnameseCustomerService.findAll());
        ForeignCustomerView.displayInFor(foreignCustomerService.findAll());
    }
    private static void searchName(){
        System.out.println("Tìm kiếm theo tên gần đúng");
        String name=scanner.nextLine();
        List<Person> listAll= new ArrayList<>();
        List<VietnameseCustomer> vietnameseCustomerList=vietnameseCustomerService.findAll();
        List<ForeignCustomer> foreignCustomerList=foreignCustomerService.findAll();
        listAll.addAll(vietnameseCustomerList);
        listAll.addAll(foreignCustomerList);
        List<Person> personList = new ArrayList<>();
        for (Person person: listAll){
            if(person.getFullName().toLowerCase().contains(name.toLowerCase())){
                personList.add(person);
            }
        }
        if(personList.isEmpty()){
            System.out.println("Danh sách tìm kiếm trống");
        }
        for (Person person: personList){
            System.out.println(person);
        }
    }
    private static void creatElectricBill(){
        System.out.println("Thêm mới hóa đơn");
        System.out.println("-----------------");
        displayCustomer();
        System.out.println("-------------------------------------------------------------");
        ElectricBill electricBill= new ElectricBill();
        ElectricBillView.inputData(electricBill);
        if(CheckPerson.checkId("vietnam",electricBill.getCustomerId())){
            VietnameseCustomer vietnameseCustomer=vietnameseCustomerService.findById(electricBill.getCustomerId());
            double totalAmount=vietnameseCustomer.calculateTotalAmount(electricBill.getConsumedKW(),electricBill.getUnitPrice());
            electricBill.setTotalAmount(totalAmount);
            boolean check=electricBillService.add(electricBill);
            if(check){
                System.out.println("Thêm hóa đơn thành công");
            }else {
                System.out.println("Thêm hóa đơn không thành công");
            }

        }else if(CheckPerson.checkId("foreign",electricBill.getCustomerId())){
            ForeignCustomer foreignCustomer=foreignCustomerService.findById(electricBill.getCustomerId());
            double totalAmount=foreignCustomer.calculateTotalAmount(electricBill.getConsumedKW(),electricBill.getUnitPrice());
            electricBill.setTotalAmount(totalAmount);
            boolean check=electricBillService.add(electricBill);
            if(check){
                System.out.println("Thêm hóa đơn thành công");
            }else {
                System.out.println("Thêm hóa đơn không thành công");
            }
        }else {
            System.out.println("Mã khách hàng bạn nhập không đúng");
        }

    }
    private static void displayElectric(){
        System.out.println("Danh sách hóa đơn");
        System.out.println("--------------------------------------------------");
        ElectricBillView.displayElectric(electricBillService.findAll());
    }
    private static void editElectricBill(){
        displayElectric();
        int index;
        try {
            System.out.println("Nhập số thứ tự hóa đơn bạn muốn sửa: ");
            index = Integer.parseInt(scanner.nextLine());
            List<ElectricBill> electricBillList = electricBillService.findAll();

            if (index < 1 || index > electricBillList.size()) {
                System.out.println("Số thứ tự không hợp lệ!");
                return;
            }

            ElectricBill editElectric = electricBillList.get(index - 1);
            ElectricBill electric=ElectricBillView.inputData(editElectric);
            boolean check= electricBillService.editById(electric);
            if(check){
                System.out.println("Cập nhật thành công");
            }else {
                System.out.println("Cập nhật không thành công");
            }

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }


    }
}
