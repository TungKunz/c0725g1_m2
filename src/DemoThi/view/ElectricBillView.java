package DemoThi.view;

import DemoThi.entity.ElectricBill;
import DemoThi.validate.CheckElectricBill;
import DemoThi.validate.CheckPerson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ElectricBillView {
    private static final Scanner scanner = new Scanner(System.in);

    public static ElectricBill inputData(ElectricBill electricBill){
        electricBill.setCustomerId(inputCustomerId());
        electricBill.setInvoiceDate(inputInvoiceDate());
        electricBill.setConsumedKW(inputConsumedKW());
        electricBill.setUnitPrice(inputUnitPrice());
        return electricBill;
    }
public static String inputInvoicedId(){
        System.out.println("Nhập id: ");
        return scanner.nextLine();
    }
    public static String inputCustomerId(){
        while (true){
            System.out.println("Nhập mã khách hàng");
            String customerId=scanner.nextLine();
            if(CheckPerson.checkId("vietnam",customerId) || CheckPerson.checkId("foreign",customerId)){
                return customerId;
            }
            System.out.println("Nhập không đúng định dạng mời bạn nhập lại");
        }
    }
    public static LocalDate inputInvoiceDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày lập hóa đơn (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                if (CheckElectricBill.checkDay(input)) {
                    LocalDate date = LocalDate.parse(input, formatter);
                    if (date.isAfter(LocalDate.now())) {
                        System.out.println("Ngày không được lớn hơn ngày hiện tại. Thử lại!");
                        continue;
                    }
                    return date;
                } else {
                    System.out.println("Định dạng ngày không đúng (dd/MM/yyyy). Thử lại!");
                }

            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Thử lại!");
            }
        }
    }
    public static double inputConsumedKW(){
        while (true){
            try {
                System.out.println("Nhập số lượng điện tiêu thụ");
                double consumedKW=Double.parseDouble(scanner.nextLine());
                if(consumedKW>0){
                    return consumedKW;
                }
                System.out.println("Số lương điện tiêu thụ phải > 0");
            }catch (NumberFormatException e){
                System.out.println("Lỗi định dạng");
            }
        }
    }
    public static double inputUnitPrice(){
        while (true){
            try {
                System.out.println("Nhập đơn giá");
                double unitPrice=Double.parseDouble(scanner.nextLine());
                if(unitPrice>0){
                    return unitPrice;
                }
                System.out.println("Đơn giá phải > 0");
            }catch (NumberFormatException e){
                System.out.println("Lỗi định dạng");
            }
        }
    }
    public static void displayElectric(List<ElectricBill> electricBillList){
        if(electricBillList.isEmpty()){
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < electricBillList.size(); i++) {
            System.out.println((i+1)+". "+ electricBillList.get(i).toString());

        }
    }

}
