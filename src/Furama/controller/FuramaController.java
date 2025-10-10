package Furama.controller;

import Furama.entity.Booking;
import Furama.entity.Contract;
import Furama.entity.facility.Facility;
import Furama.entity.facility.House;
import Furama.entity.facility.Room;
import Furama.entity.facility.Villa;
import Furama.entity.person.Customer;
import Furama.entity.person.Employee;
import Furama.service.*;
import Furama.validate.CheckFacility;
import Furama.validate.CheckPerson;
import Furama.view.BookingView;
import Furama.view.ContractView;
import Furama.view.facility.HouseView;
import Furama.view.facility.RoomView;
import Furama.view.facility.VillaView;
import Furama.view.person.CustomerView;
import Furama.view.person.EmployeeView;


import java.util.Queue;
import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IService<Employee> employeeService = new EmployeeService();
    private static final IService<Customer> customerService = new CustomerService();
    private static final IFacilityService facilityService = new FacilityService();
    private static final IBookingService bookingService = new BookingService();
    private static final IContactService contractService = new ContactService();

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
                case 3 -> facilityManagement();
                case 4 -> bookingManagement();
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
        boolean flag = true;
        while (flag) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Return main menu");
            System.out.print("Select an option employees : ");
            int type;
            try {
                type = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
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
                        if (CheckPerson.checkId("employee", idEmployee)) {
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
                        if (CheckPerson.checkId("employee", idEmployee)) {
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
                default -> flag = false;
            }
        }
    }

    public static void customerManagement() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Delete customers");
            System.out.println("5. Return main menu");
            System.out.print("Select an option customer: ");
            int type;
            try {
                type = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (type) {
                case 1 -> {
                    System.out.println("Danh sách khách hàng");
                    CustomerView.showList(customerService.findAll());
                }
                case 2 -> {
                    Customer customer = new Customer();
                    String id;
                    while (true){
                        id=CustomerView.inputCustomerId();
                        Customer checkCustomer= customerService.findById(id);
                        if(checkCustomer==null){
                            break;
                        }
                    }
                    CustomerView.inputDataForCustomer("add",id, customer);
                    boolean check= customerService.add(customer);
                    if(check){
                        System.out.println("Thêm mới thành công");
                    }else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 3 -> {
                    String idCustomer;
                    while (true) {
                        System.out.println("Nhập mã khách hàng bạn muốn sửa có định dạng: KH-YYYY");
                        idCustomer = scanner.nextLine();
                        if (CheckPerson.checkId("customer", idCustomer)) {
                            break;
                        } else {
                            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
                        }
                    }
                    Customer editCustomer = customerService.findById(idCustomer);
                    if (editCustomer != null) {
                        String id= CustomerView.inputCustomerId();
                        Customer newCustomer = CustomerView.inputDataForCustomer("edit", id,editCustomer);
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
                case 4 -> {
                    String idCustomer;
                    while (true) {
                        System.out.println("Nhập mã khách hàng bạn muốn xóa có định dạng: KH-YYYY");
                        idCustomer = scanner.nextLine();
                        if (CheckPerson.checkId("customer", idCustomer)) {
                            break;
                        } else {
                            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
                        }
                    }
                    Customer deleteCustomer = customerService.findById(idCustomer);
                    if (deleteCustomer != null) {
                        boolean result = customerService.deleteById(deleteCustomer);
                        if (result) {
                            System.out.println("Thông tin khách hàng đã được xóa thành công!");
                        } else {
                            System.out.println("Có lỗi khi cập nhật thông tin khách hàng!");
                        }
                    } else {
                        System.out.println("Không tìm thấy mã khách hàng mà bạn muốn sửa!");
                    }
                }
                default -> flag = false;
            }
        }
    }

    public static void facilityManagement() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Display list  facility");
            System.out.println("2. Add new  facility");
            System.out.println("3. Edit  facility");
            System.out.println("4. Delete  facility");
            System.out.println("5. Return main menu");
            System.out.print("Select an option facility: ");
            int type;
            try {
                type = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (type) {
                case 1 -> {
                    System.out.println("Display list  facility");
                    VillaView.showAllFacilities(facilityService.displayAll());
                }
                case 2 -> {
                    System.out.println("Add new facility");
                    boolean flag_2 = true;
                    while (flag_2) {
                        System.out.println("""
                                1. Add new Villa
                                2. Add new House
                                3. Add new Room
                                4. Return
                                """);
                        int choose;
                        try {
                            System.out.println("Select an option: ");
                            choose = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a number.");
                            continue;
                        }

                        switch (choose) {
                            case 1 -> {
                                System.out.println("Add new Villa");
                                Villa villa = new Villa();
                                VillaView.inputData("add", villa);
                                facilityService.add(villa);
                                System.out.println("Thêm mới thành công");
                            }
                            case 2 -> {
                                System.out.println("Add new House");
                                House house = new House();
                                HouseView.inputData("add", house);
                                facilityService.add(house);
                                System.out.println("Thêm mới thành công");
                            }
                            case 3 -> {
                                System.out.println("Add new Room");
                                Room room = new Room();
                                RoomView.inputData("add", room);
                                facilityService.add(room);
                                System.out.println("Thêm mới thành công");
                            }
                            case 4 -> flag_2 = false;
                            default -> System.out.println("Invalid choice! Please select 1-4.");
                        }
                    }

                }
                case 3 -> {
                    System.out.println("Edit facility");
                    String id;
                    String typeFacility;
                    while (true) {
                        System.out.println("""
                                1.SVVL-YYYY : mã villa
                                2.SVHO-YYYY : mã house
                                3.SVRO-YYYY : mã room""");
                        System.out.println("Nhập id Facility bạn muốn sửa");
                        id = scanner.nextLine();
                        if (CheckFacility.checkId("villa", id)) {
                            typeFacility="villa";
                            break;
                        } else if (CheckFacility.checkId("house", id)) {
                            typeFacility="house";
                            break;
                        } else if (CheckFacility.checkId("room", id)) {
                            typeFacility="room";
                            break;
                        } else {
                            System.out.println("bạn nhập sai định dạng");
                        }
                    }

                    Facility facility = facilityService.findById(id);
                    if (facility != null) {
                        if(typeFacility.equals("villa")){
                            Facility editVilla = VillaView.inputData("edit",(Villa) facility);
                            boolean result= facilityService.update(editVilla);
                            if(result){
                                System.out.println("Cập nhật facility thành công");
                            }else {
                                System.out.println("Cập nhật facility không thành công");
                            }
                        }else if(typeFacility.equals("house")){
                            Facility editHouse = HouseView.inputData("edit",(House) facility);
                            boolean result= facilityService.update(editHouse);
                            if(result){
                                System.out.println("Cập nhật facility thành công");
                            }else {
                                System.out.println("Cập nhật facility không thành công");
                            }
                        }else {
                            Facility editRoom = RoomView.inputData("room",(Room) facility);
                            boolean result= facilityService.update(editRoom);
                            if(result){
                                System.out.println("Cập nhật facility thành công");
                            }else {
                                System.out.println("Cập nhật facility không thành công");
                            }
                        }
                    }else {
                        System.out.println("Không tìm thấy mã facility");
                    }
                }
                case 4 -> {
                    System.out.println("Delete Facility");
                    String id;
                    String typeFacility;
                    while (true) {
                        System.out.println("""
                                1.SVVL-YYYY : mã villa
                                2.SVHO-YYYY : mã house
                                3.SVRO-YYYY : mã room""");
                        System.out.println("Nhập id Facility bạn muốn xóa");
                        id = scanner.nextLine();
                        if (CheckFacility.checkId("villa", id)) {
                            typeFacility="villa";
                            break;
                        } else if (CheckFacility.checkId("house", id)) {
                            typeFacility="house";
                            break;
                        } else if (CheckFacility.checkId("room", id)) {
                            typeFacility="room";
                            break;
                        } else {
                            System.out.println("bạn nhập sai định dạng");
                        }
                    }

                    Facility facility = facilityService.findById(id);
                    if (facility != null) {
                        if(typeFacility.equals("villa")){
                            boolean result= facilityService.delete(facility);
                            if(result){
                                System.out.println("Xóa facility thành công");
                            }else {
                                System.out.println("Xóa facility không thành công");
                            }
                        }else if(typeFacility.equals("house")){
                            boolean result= facilityService.delete(facility);
                            if(result){
                                System.out.println("Xóa facility thành công");
                            }else {
                                System.out.println("Xóa facility không thành công");
                            }
                        }else {
                            boolean result= facilityService.delete(facility);
                            if(result){
                                System.out.println("Xóa facility thành công");
                            }else {
                                System.out.println("Xóa facility không thành công");
                            }
                        }
                    }else {
                        System.out.println("Không tìm thấy mã facility");
                    }

                }
                case 5-> flag = false;
                default -> System.out.println("Invalid choice! Please select 1-4.");

            }

        }
    }
    public static void bookingManagement() {
        boolean flag = true;
        while (flag){
            System.out.println("1. Add new booking");
            System.out.println("2. Display list  booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.print("Select an option booking: ");
            int type;
            try {
                type = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (type){
                case 1 -> {
                    System.out.println("Add new booking");
                    Booking booking = BookingView.addNewBookingView();
                    if (bookingService.add(booking)) {
                        System.out.println("Thêm mới booking thành công!");
                    } else {
                        System.out.println("Thêm booking thất bại (trùng hoặc lỗi dữ liệu)");
                    }
                }

                case 2->{
                    System.out.println("Display list  booking");
                    BookingView.displayAllBookings();
                }
                case 3 -> {
                    System.out.println("Display list  booking");
                    BookingView.displayAllBookings();
                    System.out.println("Create new contracts");
                    Contract tempContract = ContractView.inputContract();
                    Queue<Booking> bookingQueue = bookingService.getBookingQueueByOrder();

                    if (bookingQueue.isEmpty()) {
                        System.out.println("Không có booking nào để tạo hợp đồng!");
                        break;
                    }

                    Booking currentBooking = bookingQueue.remove();
                    String bookingId = currentBooking.getBookingId();
                    Contract contract = new Contract(
                            tempContract.getContractId(),
                            bookingId,
                            tempContract.getDeposit(),
                            tempContract.getTotalPayment()
                    );

                    boolean success = contractService.addContract(contract);
                    if (success) {
                        bookingService.removeBooking(currentBooking);
                        System.out.println("Contract created successfully for booking: " + bookingId);
                    } else {
                        System.out.println("Failed to create contract!");
                    }
                }

                case 4->{
                    System.out.println("Danh sách");
                    ContractView.displayContractList(contractService.findAllContracts());
                }
                default -> flag=false;
            }
        }
    }

//    public static void promotionManagement() {
//        System.out.println("1. Display list customers use service");
//        System.out.println("2. Display list customers get voucher");
//        System.out.println("3. Return main menu");
//        System.out.print("Select an option promotion: ");
//        int type = Integer.parseInt(scanner.nextLine());
//    }

}
