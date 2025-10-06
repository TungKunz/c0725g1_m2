package Furama.view.person;

import Furama.validate.CheckPerson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonView {
    private static final Scanner scanner = new Scanner(System.in);
    static String inputName() {
        while (true) {
            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();
            if (CheckPerson.checkName(name)) return name;
            System.out.println("Nhập sai định dạng cho tên mời bạn nhập lại");
        }
    }

    static LocalDate inputBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                if (CheckPerson.checkBirthDate(input)) {
                    return LocalDate.parse(input, formatter);
                }
                System.out.println("Phải đủ 18 tuổi. Thử lại!");
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Thử lại!");
            }
        }
    }



    static byte inputGender() {
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


    static String inputIdentityNumber() {
        while (true) {
            System.out.print("Nhập CMND (9 hoặc 12 số): ");
            String cMND = scanner.nextLine();
            if (CheckPerson.checkIdentityNumber(cMND)) return cMND;
            System.out.println("CMND phải đủ 9 hoặc 12 số. Thử lại!");
        }
    }

    static String inputPhone() {
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, bắt đầu 0): ");
            String phone = scanner.nextLine();
            if (CheckPerson.checkPhoneNumber(phone)) return phone;
            System.out.println("Số điện thoại không hợp lệ. Thử lại!");
        }
    }

    static String inputEmail() {
        while (true) {
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();
            if (CheckPerson.checkEmail(email)) return email;
            System.out.println("Email phải có dạng ...@gmail.com. Thử lại!");
        }
    }
}
