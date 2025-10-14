package DemoThi.view;

import DemoThi.entity.VietnameseCustomer;


import java.util.List;
import java.util.Map;

public class VietnameseCustomerView extends PersonView{
    public static VietnameseCustomer inputData(String type, VietnameseCustomer vietnameseCustomer, String customeType){
        if(type.equals("add")){
            vietnameseCustomer.setCustomId(inputId("vietnam"));
        }
        vietnameseCustomer.setFullName(inputFullName());
        vietnameseCustomer.setCustomerType(customeType);
        vietnameseCustomer.setConsumptionLimit(consumptionLimit());
        return vietnameseCustomer;
    }
    private static int consumptionLimit(){
        System.out.println("Nhập định mức tiêu thụ");
        return Integer.parseInt(scanner.nextLine());
    }
    public static int customerType(List<String> customerTypeList) {
        int index = 1;
        for (String key : customerTypeList) {
            System.out.println(index + ". " + key);
            index++;
        }
        System.out.print("Chọn loại khách (nhập số): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void displayInFor(List<VietnameseCustomer> vietnameseCustomerList){
        if(vietnameseCustomerList.isEmpty()){
            System.out.println("Danh sách khách hàng Việt Nam trống ");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (VietnameseCustomer vn:vietnameseCustomerList){
            System.out.println(vn);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
