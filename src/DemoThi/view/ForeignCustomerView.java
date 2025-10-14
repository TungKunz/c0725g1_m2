package DemoThi.view;

import DemoThi.entity.ForeignCustomer;


import java.util.List;

public class ForeignCustomerView extends PersonView{
    public static ForeignCustomer inputData(String type,  ForeignCustomer foreignCustomer, String nationality){
        if(type.equals("add")){
            foreignCustomer.setCustomId(inputId("foreign"));
        }
        foreignCustomer.setFullName(inputFullName());
        foreignCustomer.setNationality(nationality);
        return foreignCustomer;
    }
    public static int inputNationality(List<String> nationality){
        int index = 1;
        for (String key : nationality) {
            System.out.println(index + ". " + key);
            index++;
        }
        System.out.print("Chọn quốc gia (nhập số): ");
        return Integer.parseInt(scanner.nextLine());
    }
    public static void displayInFor(List<ForeignCustomer> foreignCustomerList){
        if(foreignCustomerList.isEmpty()){
            System.out.println("Danh sách khách hàng nước ngoài trống ");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (int i = 0; i < foreignCustomerList.size(); i++) {
            System.out.println((i+1) + ". " + foreignCustomerList.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
