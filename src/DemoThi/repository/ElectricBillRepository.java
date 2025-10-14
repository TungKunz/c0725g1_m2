package DemoThi.repository;

import DemoThi.entity.ElectricBill;
import DemoThi.util.ReadAndWriteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElectricBillRepository implements IElectricBillRepository<ElectricBill> {
    private final String ELECTRIC_FILE = "D:\\CodeGym\\Module2\\src\\DemoThi\\data\\electric_bill.csv";
    @Override
    public List<ElectricBill> findAll() {
        List<ElectricBill> electricBillList=new ArrayList<>();
        try {
            List<String> lines= ReadAndWriteFile.readFileCSVToList(ELECTRIC_FILE);
            for (String line: lines){
                String[] array=line.split(",");
                try{
                    ElectricBill electricBill= new ElectricBill(array[0],array[1], LocalDate.parse(array[2]), Double.parseDouble(array[3]),Double.parseDouble(array[4]),Double.parseDouble(array[5]));
                    electricBillList.add(electricBill);
                }catch (Exception e){
                    continue;
                }
            }
        }catch (IOException e){
            System.out.println("Lỗi");
        }
        return  electricBillList;
    }

    @Override
    public boolean add(ElectricBill electricBill) {
        try {
            Furama.util.ReadAndWriteFile.writeListStringToCSV(ELECTRIC_FILE,
                    List.of(electricBill.toInForCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<ElectricBill> electricBillList) {
        try {
            List<String> lines = new ArrayList<>();
            for (ElectricBill e : electricBillList) lines.add(e.toInForCSV());
            Furama.util.ReadAndWriteFile.writeListStringToCSV(ELECTRIC_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
