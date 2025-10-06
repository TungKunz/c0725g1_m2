package Furama.view.person;

import Furama.entity.person.Customer;
import Furama.validate.CheckPerson;

import java.util.List;
import java.util.Scanner;

public class CustomerView extends  PersonView{
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

    public static String inputCustomerId() {
        while (true) {
            System.out.print("Nhập mã khách hàng (KH-YYYY): ");
            String id = scanner.nextLine();
            if (CheckPerson.checkId("customer",id)) return id;
            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
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
