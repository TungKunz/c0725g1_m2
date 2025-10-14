package DemoThi.repository;

import DemoThi.entity.VietnameseCustomer;
import DemoThi.validate.CheckPerson;
import Furama.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VietnameseCustomerRepository implements IVietnameseCustomerRepository<VietnameseCustomer> {
    private final String CUSTOMER_FILE = "D:\\CodeGym\\Module2\\src\\DemoThi\\data\\customer.csv";
    private final String CUSTOMER_TYPE_FILE = "D:\\CodeGym\\Module2\\src\\DemoThi\\data\\customerType.csv";
    @Override
    public List<VietnameseCustomer> findAll() {
        List<VietnameseCustomer> foreignCustomerList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(CUSTOMER_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (CheckPerson.checkId("vietnam",array[0])) {
                        VietnameseCustomer vietnameseCustomer = new VietnameseCustomer(array[0], array[1],array[2],Integer.parseInt(array[3]));
                        foreignCustomerList.add(vietnameseCustomer);
                    }
                }catch (Exception e){
                    System.out.println("lỗi");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return foreignCustomerList;
    }

    @Override
    public boolean add(VietnameseCustomer foreignCustomer) {
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE,
                    List.of(foreignCustomer.toInForCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<VietnameseCustomer> vietnameseCustomerList) {
        try {
            List<String> lines = new ArrayList<>();
            for (VietnameseCustomer vn : vietnameseCustomerList) lines.add(vn.toInForCSV());
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<String> customerTypelist() {
        List<String> customerTypeList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(CUSTOMER_TYPE_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    String name = array[1].trim();
                    customerTypeList.add(name);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return customerTypeList;
    }

}

