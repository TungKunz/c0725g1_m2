package Furama.view.facility;


import Furama.entity.facility.Facility;
import Furama.entity.facility.Villa;


import java.util.Map;
import java.util.Scanner;

public class VillaView extends FacilityView{
    private static final Scanner scanner = new Scanner(System.in);
    public static Villa inputData(String action, Villa villa) {
        if (action.equals("add")) {
            villa.setIdFacility(inputId());
        }
        villa.setNameFacility(inputName());
        villa.setAreaFacility(inputArea());
        villa.setCostFacility(inputCost());
        villa.setNumberMemberMaxFacility(inputNumberMax());
        villa.setRentalStyleFacility(inputRentalStyle());
        villa.setRoomStandards(inputRoomStandards());
        villa.setPoolArea(inputPoolArea());
        villa.setNumberOfFloors(inputNumberOfFloors());
        return villa;
    }
//    public static String inputId(){
//        while (true) {
//            System.out.print("Nhập mã villa (SVVL-YYYY): ");
//            String id = scanner.nextLine();
//            if (CheckFacility.checkId("villa",id)) return id;
//            System.out.println("Mã villa không đúng định dạng. Thử lại!");
//        }
//    }

    public static String inputRoomStandards(){
        System.out.println("Nhập tiêu chuẩn phòng");
        return scanner.nextLine();
    }
    public static double inputPoolArea(){
        while (true){
            try {
                System.out.println("Nhập diện tích hồ bơi");
                double poolArea= Double.parseDouble(scanner.nextLine());
                if(poolArea >= 30){
                    return poolArea;
                }else{
                    System.out.println("Nhập sai đinh dạng");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng!!!");
            }

        }
    }
    public static int inputNumberOfFloors(){
        while (true){
            try {
                System.out.println("Nhập số tầng");
                int floors= Integer.parseInt(scanner.nextLine());
                if(floors > 0){
                    return floors;
                }else{
                    System.out.println("Nhập số lượng tầng phải > 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng!!!");
            }

        }
    }
    public static void showAllFacilities(Map<Facility, Integer> facilities) {
        if (facilities.isEmpty()) {
            System.out.println("Danh sách Facility trống!");
        } else {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                System.out.println(entry.getKey() + " - Số lần sử dụng: " + entry.getValue());
            }
        }
    }

}
