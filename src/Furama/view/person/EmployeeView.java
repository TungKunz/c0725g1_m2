package Furama.view.person;

import Furama.entity.person.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] arraysEducationLevel = {"Trung cấp", "Cao đẳng", "Đại học", "Sau đại học"};
    private static final String[] arraysPosition = {"Lễ tân", "Phục vụ", "Chuyên viên", "Giám sát", "Quản lý", "Giám đốc"};

    public static Employee inputDataForEmployee(String action, Employee employee) {
        if (action.equals("add")) {
            employee.setIdPerson(inputEmployeeId());
        }
        employee.setNamePerson(inputName());
        employee.setDateOfBirthPerson(inputBirthDate());
        employee.setGenderPerson(inputGender());
        employee.setIdentityNumberPerson(inputIdentityNumber());
        employee.setPhoneNumberPerson(inputPhone());
        employee.setEmailPerson(inputEmail());
        employee.setEducationLevel(inputEducation());
        employee.setPosition(inputPosition());
        employee.setSalary(inputSalary());

        return employee;
    }

    private static String inputEmployeeId() {
        while (true) {
            System.out.print("Nhập mã nhân viên (NV-YYYY): ");
            String id = scanner.nextLine();
            if (Pattern.matches("NV-\\d{4}", id)) return id;
            System.out.println("Mã nhân viên không đúng định dạng. Thử lại!");
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

    private static String inputEducation() {
        while (true) {
            System.out.println("""
                    Nhập trình độ học vấn
                    1. Trung cấp
                    2. Cao Đẳng
                    3. Đại học
                    4. Sau Đại học""");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 1 && index <= arraysEducationLevel.length) {
                    return arraysEducationLevel[index - 1];
                } else {
                    System.out.println("Không hợp lệ, nhập chữ số từ 1->4 tương ứng trình độ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->4 tương ứng trình độ");
            }

        }
    }

    private static String inputPosition() {
        while (true) {
            System.out.println("""
                    Nhập vị trí:
                    1. Lễ tân
                    2. Phục vụ
                    3. Chuyên viên
                    4. Giám sát
                    5. Quản lý
                    6. Giám đốc""");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 1 && index <= arraysPosition.length) {
                    return arraysPosition[index - 1];
                } else {
                    System.out.println("Không hợp lệ, nhập chữ số từ 1->6 tương ứng vị trí làm việc");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->6 tương ứng vị trí làm việc");
            }

        }
    }

    private static int inputSalary() {
        while (true) {
            try {
                System.out.print("Nhập lương của nhân viên: ");
                int salary = Integer.parseInt(scanner.nextLine());
                if (salary > 0) {
                    return salary;
                } else {
                    System.out.println("Lương nhân viên phải lớn hơn 0. Thử lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lương nhân viên phải là số. Thử lại!");
            }
        }
    }

    public static void showList(List<Employee> employeeList) {
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}