package DemoThi.repository;

import DemoThi.entity.ForeignCustomer;
import DemoThi.validate.CheckPerson;
import Furama.util.ReadAndWriteFile;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForeignCustomerRepository implements IForeignCustomerRepository<ForeignCustomer> {
    private final String CUSTOMER_FILE = "D:\\CodeGym\\Module2\\src\\DemoThi\\data\\customer.csv";
    private final String NATIONALITY_FILE = "D:\\CodeGym\\Module2\\src\\DemoThi\\data\\nationality.csv";
    @Override
    public List<ForeignCustomer> findAll() {
        List<ForeignCustomer> foreignCustomerList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(CUSTOMER_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (CheckPerson.checkId("foreign",array[0])) {
                        ForeignCustomer foreignCustomer = new ForeignCustomer(array[0], array[1], array[2]);
                        foreignCustomerList.add(foreignCustomer);
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
    public boolean add(ForeignCustomer foreignCustomer) {
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE,
                    List.of(foreignCustomer.toInForCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<ForeignCustomer> foreignCustomerList) {
        try {
            List<String> lines = new ArrayList<>();
            for (ForeignCustomer f : foreignCustomerList) lines.add(f.toInForCSV());
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<String> nationalityList() {
        List<String> customerTypeList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(NATIONALITY_FILE);
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
