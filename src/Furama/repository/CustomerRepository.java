package Furama.repository;

import Furama.entity.person.Customer;
import Furama.util.ReadAndWriteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String CUSTOMER_FILE = "src/Furama/data/customer.csv";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = ReadAndWriteFile.readFileCSVToList(CUSTOMER_FILE);
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }
        String[] array;

        for (String line : stringList) {
            array = line.split(",");
            String idPerson = array[0];
            String namePerson = array[1];
            LocalDate dateOfBirthPerson = LocalDate.parse(array[2]);
            byte genderPerson = Byte.parseByte(array[3]);
            String identityNumberPerson = array[4];
            String phoneNumberPerson = array[5];
            String emailPerson = array[6];
            String customerType = array[7];
            String address = array[8];
            Customer customer = new Customer(idPerson, namePerson, dateOfBirthPerson, genderPerson, identityNumberPerson, phoneNumberPerson, emailPerson, customerType, address);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public boolean add(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Customer deleteCustomer) {
        List<Customer> customerList = findAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdPerson().equals(deleteCustomer.getIdPerson())) {
                customerList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, false);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean editById(Customer editCustomer) {
        List<Customer> customerList = findAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdPerson().equals(editCustomer.getIdPerson())) {
                customerList.set(i, editCustomer);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, false);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public Customer findById(String idPerson) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList) {
            if (customer.getIdPerson().equals(idPerson)) {
                return customer;
            }
        }
        return null;
    }
}
