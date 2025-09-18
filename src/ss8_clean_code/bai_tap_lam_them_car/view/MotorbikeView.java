package ss8_clean_code.bai_tap_lam_them_car.view;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;

import java.util.Scanner;

public class MotorbikeView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(MotorbikeEntity[] motorbikes) {
        System.out.printf("%-12s | %-15s | %-10s | %-15s | %-10s\n",
                "Biển số", "Hãng SX", "Năm SX", "Chủ sở hữu", "Công suất");
        System.out.println("-----------------------------------------------------------------");

        for (MotorbikeEntity bike : motorbikes) {
            if (bike != null) {
                System.out.println(bike);
            }
        }
    }

    public static MotorbikeEntity inputDataForMotorbike(){
        System.out.println("Thêm mới");
        System.out.println("Nhập biển kiểm soát");
        String numberPlate=scanner.nextLine();
        System.out.println("Nhập tên hãng sản xuất");
        String manufacturerName=scanner.nextLine();
        System.out.println("Nhập năm sản xuất ");
        int manufactureYear=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu ");
        String owner=scanner.nextLine();
        System.out.println("Nhập công suất của xe ");
        int power=Integer.parseInt(scanner.nextLine());
        return new MotorbikeEntity(numberPlate,manufacturerName,manufactureYear,owner,power);
    }
    public static String inputNumberPlateForDelete() {
        System.out.println("Xóa xe");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }
    public static String inputNumberPlateForSearch(){
        System.out.println("Tìm xe");
        System.out.println("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }
}
