package Furama.view.person;

import Furama.entity.person.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] arraysType = {"Diamond", "Platinum", "Gold","Silver","Member"};
    public static Customer inputDataForCustomer(String action, Customer customer) {
        if (action.equals("add")) {
            customer.setIdPerson(inputCustomerId());
        }
        customer.setNamePerson(inputName());
        customer.setDateOfBirthPerson(inputBirthDate());
        customer.setGenderPerson(inputGender());
        customer.setIdentityNumberPerson(inputIdentityNumber());
        customer.setPhoneNumberPerson(inputPhone());
        customer.setEmailPerson(inputEmail());
        customer.setCustomerType(inputCustomerType());
        customer.setAddress(inputAddress());
        return customer;
    }

    private static String inputCustomerId() {
        while (true) {
            System.out.print("Nhập mã nhân viên (KH-YYYY): ");
            String id = scanner.nextLine();
            if (Pattern.matches("NV-\\d{4}", id)) return id;
            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
        }
    }

    private static String inputName() {
        while (true) {
            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine();
            if (Pattern.matches("^([A-Z][a-z]{1,8})(\\s[A-Z][a-z]{1,8})*$", name)) return name;
            System.out.println("Nhập sai định dạng cho tên mời bạn nhập lại");
        }
    }

    private static LocalDate inputBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                LocalDate birthDate = LocalDate.parse(scanner.nextLine(), formatter);
                if (Period.between(birthDate, LocalDate.now()).getYears() >= 18) return birthDate;
                System.out.println("Phải đủ 18 tuổi. Thử lại!");
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Thử lại!");
            }
        }
    }

    private static byte inputGender() {
        while (true) {
            System.out.println("""
                    Nhập giới tính
                    0. Nam
                    1. Nữ
                    2. Khác""");
            try {
                byte gender = Byte.parseByte(scanner.nextLine());
                if (gender >= 0 && gender <= 2) {
                    return gender;
                } else {
                    System.out.println("Không hợp lệ, nhập số đúng với giới tính");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ, nhập số đúng với giới tính");
            }
        }
    }


    private static String inputIdentityNumber() {
        while (true) {
            System.out.print("Nhập CMND (9 hoặc 12 số): ");
            String cMND = scanner.nextLine();
            if (Pattern.matches("\\d{9}|\\d{12}", cMND)) return cMND;
            System.out.println("CMND phải đủ 9 hoặc 12 số. Thử lại!");
        }
    }

    private static String inputPhone() {
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, bắt đầu 0): ");
            String phone = scanner.nextLine();
            if (Pattern.matches("0\\d{9}", phone)) return phone;
            System.out.println("Số điện thoại không hợp lệ. Thử lại!");
        }
    }

    private static String inputEmail() {
        while (true) {
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();
            if (Pattern.matches("^[A-Za-z0-9_]+@gmail\\.com$", email)) return email;
            System.out.println("Email phải có dạng ...@gmail.com. Thử lại!");
        }
    }
    private static String inputCustomerType() {
        while (true) {
            System.out.println("""
                Nhập hạng
                1. Diamond
                2. Platinum
                3. Gold
                4. Silver
                5. Member""");
            try {
                int indexType = Integer.parseInt(scanner.nextLine());
                if (indexType >= 1 && indexType <= arraysType.length) {
                    return arraysType[indexType - 1];
                } else {
                    System.out.println("Không hợp lệ, nhập chữ số từ 1->5 tương ứng hạng khách hàng");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->5 tương ứng hạng khách hàng");
            }
        }
    }
    public static String inputAddress(){
        System.out.println("Nhập địa chỉ");
        return scanner.nextLine();
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
