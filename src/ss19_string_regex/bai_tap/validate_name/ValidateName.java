package ss19_string_regex.bai_tap.validate_name;

import java.util.Scanner;

public class ValidateName {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên class");
        String nameClass=scanner.nextLine();
        if(checkName(nameClass)){
            System.out.println("OK");
        }else {
            System.out.println("Not OK");
        }
    }
    public static boolean checkName(String str){
        String regex= "[CAP]\\d{4}[GHIK]";
        return str.matches(regex);
    }
}
