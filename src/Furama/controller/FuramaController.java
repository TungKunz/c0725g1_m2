package Furama.controller;

import Furama.entity.person.Customer;
import Furama.entity.person.Employee;
import Furama.service.CustomerService;
import Furama.service.EmployeeService;
import Furama.service.IService;
import Furama.view.person.CustomerView;
import Furama.view.person.EmployeeView;


import java.util.Scanner;
import java.util.regex.Pattern;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IService<Employee> employeeService = new EmployeeService();
    private static final IService<Customer> customerService = new CustomerService();

    public static void displayMainMenu() {
        while (true) {
            System.out.println("==== CHƯƠNG TRÌNH QUẢN LÝ FURAMA ====");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1 -> employeeManagement();
                case 2 -> customerManagement();
//                case 3 -> facilityManagement();
//                case 4 -> bookingManagement();
//                case 5 -> promotionManagement();
                case 6 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
            }
        }
    }

    public static void employeeManagement() {
        boolean flag= true;
        while (flag){
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Return main menu");
            System.out.print("Select an option employees : ");
            int type = Integer.parseInt(scanner.nextLine());
            switch (type) {
                case 1 -> {
                    System.out.println("Danh sách nhân viên");
                    EmployeeView.showList(employeeService.findAll());
                }
                case 2 -> {
                    Employee employee = new Employee();
                    EmployeeView.inputDataForEmployee("add", employee);
                    employeeService.add(employee);
                    System.out.println("Thêm mới thành công");
                }
                case 3 -> {
                    String idEmployee;
                    while (true) {
                        System.out.println("Nhập mã nhân viên bạn muốn sửa có định dạng: NV-YYYY");
                        idEmployee = scanner.nextLine();
                        if (Pattern.matches("NV-\\d{4}", idEmployee)) {
                            break;
                        } else {
                            System.out.println("Mã nhân viên không đúng định dạng. Thử lại!");
                        }
                    }
                    Employee editEmployee = employeeService.findById(idEmployee);
                    if (editEmployee != null) {
                        Employee newEmployee = EmployeeView.inputDataForEmployee("edit", editEmployee);
                        boolean result = employeeService.editById(newEmployee);

                        if (result) {
                            System.out.println("Thông tin nhân viên đã được thay đổi thành công!");
                        } else {
                            System.out.println("Có lỗi khi cập nhật thông tin nhân viên!");
                        }
                    } else {
                        System.out.println("Không tìm thấy mã nhân viên mà bạn muốn sửa!");
                    }
                }
                case 4 -> {
                    String idEmployee;
                    while (true) {
                        System.out.println("Nhập mã nhân viên bạn muốn xóa có định dạng: NV-YYYY");
                        idEmployee = scanner.nextLine();
                        if (Pattern.matches("NV-\\d{4}", idEmployee)) {
                            break;
                        } else {
                            System.out.println("Mã nhân viên không đúng định dạng. Thử lại!");
                        }
                    }
                    Employee deleteEmployee = employeeService.findById(idEmployee);
                    if (deleteEmployee != null) {
                        boolean result = employeeService.deleteById(deleteEmployee);

                        if (result) {
                            System.out.println("Thông tin nhân viên đã được xóa thành công!");
                        } else {
                            System.out.println("Có lỗi khi cập nhật thông tin nhân viên!");
                        }
                    } else {
                        System.out.println("Không tìm thấy mã nhân viên mà bạn muốn sửa!");
                    }
                }
                default -> flag=false;
            }
        }
    }

    public static void customerManagement() {
        boolean flag=true;
        while (flag){
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Return main menu");
            System.out.print("Select an option customer: ");
            int type = Integer.parseInt(scanner.nextLine());
            switch (type) {
                case 1 -> {
                    System.out.println("Danh sách khách hàng");
                    CustomerView.showList(customerService.findAll());
                }
                case 2 -> {
                    Customer customer = new Customer();
                    CustomerView.inputDataForCustomer("add", customer);
                    customerService.add(customer);
                    System.out.println("Thêm mới thành công");
                }
                case 3 -> {
                    String idCustomer;
                    while (true) {
                        System.out.println("Nhập mã khách hàng bạn muốn sửa có định dạng: KH-YYYY");
                        idCustomer = scanner.nextLine();
                        if (Pattern.matches("KH-\\d{4}", idCustomer)) {
                            break;
                        } else {
                            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
                        }
                    }
                    Customer editCustomer = customerService.findById(idCustomer);
                    if (editCustomer != null) {
                        Customer newCustomer = CustomerView.inputDataForCustomer("edit", editCustomer);
                        boolean result = customerService.editById(newCustomer);
                        if (result) {
                            System.out.println("Thông tin khách hàng đã được thay đổi thành công!");
                        } else {
                            System.out.println("Có lỗi khi cập nhật thông tin khách hàng!");
                        }
                    } else {
                        System.out.println("Không tìm thấy mã khách hàng mà bạn muốn sửa!");
                    }
                }
                case 4 ->{
                    String idCustomer;
                    while (true) {
                        System.out.println("Nhập mã khách hàng bạn muốn xóa có định dạng: KH-YYYY");
                        idCustomer = scanner.nextLine();
                        if (Pattern.matches("KH-\\d{4}", idCustomer)) {
                            break;
                        } else {
                            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
                        }
                    }
                    Customer deleteCustomer = customerService.findById(idCustomer);
                    if(deleteCustomer!=null){
                        boolean result = customerService.deleteById(deleteCustomer);
                        if (result) {
                            System.out.println("Thông tin khách hàng đã được xóa thành công!");
                        } else {
                            System.out.println("Có lỗi khi cập nhật thông tin khách hàng!");
                        }
                    }
                    else {
                        System.out.println("Không tìm thấy mã khách hàng mà bạn muốn sửa!");
                    }
                }
                default -> flag=false;
            }
        }
    }
//
//    public static void facilityManagement() {
//        System.out.println("1. Display list  facility");
//        System.out.println("2. Add new  facility");
//        System.out.println("3. Edit  facility");
//        System.out.println("4. Return main menu");
//        System.out.print("Select an option facility: ");
//        int type = Integer.parseInt(scanner.nextLine());
//    }
//
//    public static void bookingManagement() {
//        System.out.println("1. Add new booking");
//        System.out.println("2. Display list  booking");
//        System.out.println("3. Create new contracts");
//        System.out.println("4. Display list contracts");
//        System.out.println("5. Edit contracts");
//        System.out.println("6. Return main menu");
//        System.out.print("Select an option booking: ");
//        int type = Integer.parseInt(scanner.nextLine());
//    }
//
//    public static void promotionManagement() {
//        System.out.println("1. Display list customers use service");
//        System.out.println("2. Display list customers get voucher");
//        System.out.println("3. Return main menu");
//        System.out.print("Select an option promotion: ");
//        int type = Integer.parseInt(scanner.nextLine());
//    }

}
