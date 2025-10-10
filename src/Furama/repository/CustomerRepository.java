package Furama.repository;

import Furama.entity.person.Customer;

import Furama.util.ReadAndWriteFile;
import Furama.validate.CheckPerson;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String CUSTOMER_FILE = "D:\\CodeGym\\Module2\\src\\Furama\\data\\person.csv";

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
            try {
                array = line.split(",");
                if (CheckPerson.checkId("customer", array[0])) {
                    Customer customer = new Customer(array[0], array[1], LocalDate.parse(array[2]), Byte.parseByte(array[3]),  array[4],  array[5],  array[6],  array[7],  array[8]);
                    customerList.add(customer);
                }
            } catch (Exception e) {
                continue;
            }
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
        return writeFileList(customerList);
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
        return writeFileList(customerList);
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

    public boolean writeFileList(List<Customer> customerList) {
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
}
