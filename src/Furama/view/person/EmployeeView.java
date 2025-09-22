package Furama.view.person;

import Furama.entity.person.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arraysEducationLevel = {"Trung cấp", "Cao đẳng", "Đại học","Sau đại học"};
    private static final String[] arraysPosition = {"lễ tân", "phục vụ", "chuyên viên", "giám sát", "quản lý", "giám đốc"};

    public static Employee inputDataForEmployee() {
        String idEmployee="NV-";
        String employeeNumber;
        while (true) {
            System.out.print("Nhập mã nhân viên (NV-YYYY): ");
            employeeNumber = scanner.nextLine();
            if (Pattern.matches("\\d{4}", employeeNumber)) {
                break;
            } else {
                System.out.println("Mã nhân viên không đúng định dạng. Thử lại!");
            }
        }
        idEmployee+=employeeNumber;
        String name;
        System.out.print("Nhập tên nhân viên: ");
        name = scanner.nextLine();

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


        int indexEducation;
        while (true) {
            System.out.println("""
                    Nhập trình độ học vấn
                    1. Trung cấp
                    2. Cao Đẳng
                    3. Đại học
                    4. Sau Đại học""");
            indexEducation = Integer.parseInt(scanner.nextLine());
            if (indexEducation >= 1 && indexEducation <= arraysEducationLevel.length) {
                break;
            } else {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->4 tương ứng trình độ");
            }
        }
        String educationLevel= arraysEducationLevel[indexEducation];
        int indexPosition;
        while (true) {
            System.out.println("""
        Nhập vị trí:
        1. Lễ tân
        2. Phục vụ
        3. Chuyên viên
        4. Giám sát
        5. Quản lý
        6. Giám đốc
        """);

            indexPosition = Integer.parseInt(scanner.nextLine());
            if (indexPosition >= 1 && indexPosition <= arraysPosition.length) {
                break;
            } else {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->6 tương ứng vị trí làm việc ");
            }
        }
        String position=arraysPosition[indexPosition-1];

        int salary;
        while (true) {
            System.out.println("Nhập lương của nhân viên ");
            salary = Integer.parseInt(scanner.nextLine());
            if (salary > 0) {
                break;
            } else {
                System.out.println("Lương nhân viên phải lớn hơn 0. Thử lại!");
            }
        }
        Employee emp = new Employee(idEmployee, name, birthDate,genderPerson,cMND,phone,emailPerson,educationLevel,position, salary);
        System.out.println("\nNhân viên mới đã được tạo:");
        return emp;

    }
    public static void showList(List<Employee> employeeList) {
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách xe trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}