package Furama.view.facility;

import Furama.entity.facility.House;

import java.util.Scanner;

public class HouseView extends FacilityView{
    private static final Scanner scanner = new Scanner(System.in);
    public static House inputData(String type, House house){
        if (type.equals("add")) {
            house.setIdFacility(inputId());
        }
        house.setNameFacility(inputName());
        house.setAreaFacility(inputArea());
        house.setCostFacility(inputCost());
        house.setNumberMemberMaxFacility(inputNumberMax());
        house.setRentalStyleFacility(inputRentalStyle());
        house.setRoomStandards(inputRoomStandards());
        house.setNumberOfFloors(inputNumberOfFloors());
        return house;
    }
//    public static String inputId(){
//        while (true) {
//            System.out.print("Nhập mã house (SVHO-YYYY): ");
//            String id = scanner.nextLine();
//            if (CheckFacility.checkId("house",id)) return id;
//            System.out.println("Mã villa không đúng định dạng. Thử lại!");
//        }
//    }
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
    public static String inputRoomStandards(){
        System.out.println("Nhập tiêu chuẩn phòng");
        return scanner.nextLine();
    }
}
