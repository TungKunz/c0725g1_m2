package Furama.view.facility;

import Furama.validate.CheckFacility;
import Furama.validate.CheckPerson;

import java.util.Scanner;

public class FacilityView {
    private static final Scanner scanner = new Scanner(System.in);
    public static String inputId(){
        while (true) {
            System.out.print("Nhập mã facility");
            String id = scanner.nextLine();
            if (CheckFacility.checkId("villa",id)){
                return id;
            }else if(CheckFacility.checkId("house",id)){
                return id;
            }else if(CheckFacility.checkId("room",id)){
                return id;
            }
            System.out.println("Mã không đúng định dạng. Thử lại!");
        }
    }
    public static String inputName(){
        while (true) {
            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();
            if (CheckFacility.checkName(name)) return name;
            System.out.println("Nhập sai định dạng cho tên mời bạn nhập lại");
        }
    }
    public static double inputArea(){
        while (true){
            try {
                System.out.println("Nhập diện tích sử dụng");
                double area= Double.parseDouble(scanner.nextLine());
                if(area >= 30){
                    return area;
                }else{
                    System.out.println("Nhập sai đinh dạng");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng!!!");
            }

        }


    }
    public static long inputCost(){
        while (true){
            try {
                System.out.println("Nhập chi phí thuê /1 đêm");
                long cost= Long.parseLong(scanner.nextLine());
                if(cost > 0){
                    return cost;
                }else{
                    System.out.println("Nhập sai đinh dạng");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng!!!");
            }

        }
    }
    public static int inputNumberMax(){
        while (true){
            try {
                System.out.println("Nhập số lượng người ");
                int number= Integer.parseInt(scanner.nextLine());
                if(number > 0 && number <20){
                    return number;
                }else{
                    System.out.println("Tối thiểu 1 người và tối đa 20 người!!!");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng!!!");
            }

        }
    }
    public static String inputRentalStyle(){
        System.out.println("Nhập kiểu thuê: theo ngày, tháng, năm");
        return scanner.nextLine();
    }
}
