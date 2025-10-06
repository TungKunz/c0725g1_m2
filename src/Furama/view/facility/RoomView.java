package Furama.view.facility;

import Furama.entity.facility.Room;


import java.util.Scanner;

public class RoomView extends FacilityView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Room inputData(String type, Room room){
        if(type.equals("add")){
            room.setIdFacility(inputId());
        }
        room.setNameFacility(inputName());
        room.setAreaFacility(inputArea());
        room.setCostFacility(inputCost());
        room.setNumberMemberMaxFacility(inputNumberMax());
        room.setRentalStyleFacility(inputRentalStyle());
        room.setFreeService(inputFreeService());
        return room;
    }
//    public static String inputId(){
//        while (true) {
//            System.out.print("Nhập mã house (SVRO-YYYY): ");
//            String id = scanner.nextLine();
//            if (CheckFacility.checkId("room",id)) return id;
//            System.out.println("Mã villa không đúng định dạng. Thử lại!");
//        }
//    }
    public static String inputFreeService(){
        System.out.println("Dịch vụ miễn phí đi kèm");
        return scanner.nextLine();
    }
}
