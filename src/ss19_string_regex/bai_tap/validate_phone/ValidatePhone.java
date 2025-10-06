package ss19_string_regex.bai_tap.validate_phone;

import java.util.Scanner;

public class ValidatePhone {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập sđt");
        String phoneNumber=scanner.nextLine();
        if(checkPhone(phoneNumber)){
            System.out.println("OK");
        }else {
            System.out.println("Not OK");
        }
    }
    public static boolean checkPhone(String phoneNumber){
        String regex= "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return phoneNumber.matches(regex);
    }
}
