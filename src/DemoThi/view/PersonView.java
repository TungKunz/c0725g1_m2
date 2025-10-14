package DemoThi.view;

import DemoThi.validate.CheckPerson;

import java.util.Scanner;

public class PersonView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String inputId(String type) {
        String id;
        if (type.equalsIgnoreCase("vietnam")) {
            while (true){
                System.out.println("Nhập mã khách hàng Việt Nam có định dạng: KHVN-XXXX");
                id = scanner.nextLine();
                if(CheckPerson.checkId("vietnam",id)){
                    return id;
                }
            }
        } else if (type.equalsIgnoreCase("foreign")) {
            while (true){
                System.out.println("Nhập mã khách hàng nước ngoài có định dạng: KHNN-XXXX");
                id = scanner.nextLine();
                if(CheckPerson.checkId("foreign",id)){
                    return id;
                }
            }
        }
        System.out.println("Loại khách hàng không hợp lệ!");
        return null;
    }

    public static String inputFullName() {
        while (true){
            System.out.println("Nhập họ và tên khách hàng");
            String fullName=scanner.nextLine();
            if(CheckPerson.checkName(fullName)){
                return fullName;
            }else {
                System.out.println("Mời bạn nhập lại tên");
            }
        }
    }

}
