package Furama.view.person;

import Furama.entity.person.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arraysType = {"Diamond", "Platinum", "Gold","Silver","Member"};

    public static Customer inputDataForCustormer() {
        String idCustomer="KH-";
        String custormerNumber;
        while (true) {
            System.out.print("Nhập 4 số mã khách hàng (KH-YYYY): ");
            custormerNumber = scanner.nextLine();
            if (Pattern.matches("\\d{4}", custormerNumber)) {
                break;
            } else {
                System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
            }
        }
        idCustomer+=custormerNumber;
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                birthDate = LocalDate.parse(input, formatter);
                if (Period.between(birthDate, LocalDate.now()).getYears() >= 18) {
                    break;
                } else {
                    System.out.println("Phải đủ 18 tuổi. Thử lại!");
                }
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Thử lại!");
            }
        }

        byte genderPerson;
        while (true) {
            System.out.println("""
                    Nhập giới tính
                    0. Nam
                    1. Nữ
                    2. Khác""");
            genderPerson = Byte.parseByte(scanner.nextLine());
            if (genderPerson <=2 && genderPerson >=0) {
                break;
            } else {
                System.out.println("Không hợp lệ, nhập số đúng với giới tính");
            }
        }


        String cMND;
        while (true) {
            System.out.print("Nhập CMND (9 hoặc 12 số): ");
            cMND = scanner.nextLine();
            if (Pattern.matches("\\d{9}|\\d{12}", cMND)) {
                break;
            } else {
                System.out.println("CMND phải đủ 9 hoặc 12 số. Thử lại!");
            }
        }
        String phone;
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, bắt đầu 0): ");
            phone = scanner.nextLine();
            if (Pattern.matches("0\\d{9}", phone)) {
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Thử lại!");
            }
        }

        String emailPerson;
        while (true) {
            System.out.println("Nhập email: ");
            emailPerson = scanner.nextLine();
            if (Pattern.matches("^[A-Za-z0-9]+@gmail\\.com$", emailPerson)) {
                break;
            } else {
                System.out.println("Email phải có dạng ...@gmail.com. Thử lại!");
            }
        }


        int indexType;
        while (true) {
            System.out.println("""
                    Nhập hạng
                    1. Diamond
                    2. Platinum
                    3. Gold
                    4. Silver
                    5. Member""");
            indexType = Integer.parseInt(scanner.nextLine());
            if (indexType >= 1 && indexType <= arraysType.length) {
                break;
            } else {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->5 tương ứng trình độ");
            }
        }
        String educationLevel= arraysType[indexType-1];

        System.out.println("Nhập địa chỉ");
        String address= scanner.nextLine();
        Customer emp = new Customer(idCustomer, name, birthDate,genderPerson,cMND,phone,emailPerson,educationLevel,address);
        System.out.println("\nKhách hàng mới đã được tạo:");
        return emp;

    }
    public static void showList(List<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println("Danh sách xe trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
