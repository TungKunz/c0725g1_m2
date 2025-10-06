package Furama.view.person;

import Furama.entity.person.Employee;
import Furama.validate.CheckPerson;

import java.util.List;
import java.util.Scanner;

public class EmployeeView extends PersonView{
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
            if (CheckPerson.checkId("employee",id)) return id;
            System.out.println("Mã nhân viên không đúng định dạng. Thử lại!");
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