package ss8_clean_code.bai_tap_lam_them_car.view;

import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;

import java.util.List;
import java.util.Scanner;

public class MotorbikeView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Motorbike> motorbikes) {
        if (motorbikes.isEmpty()) {
            System.out.println("Danh sách xe máy trống!");
            return;
        }

        System.out.printf("%-12s | %-15s | %-10s | %-15s | %-10s\n",
                "Biển số", "Hãng SX", "Năm SX", "Chủ sở hữu", "Công suất");
        System.out.println("-----------------------------------------------------------------");

        for (Motorbike bike : motorbikes) {
            System.out.println(bike);
        }
    }

    public static Motorbike inputDataForMotorbike() {
        System.out.println("Thêm mới xe máy");
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = scanner.nextLine();
        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập công suất của xe: ");
        int power = Integer.parseInt(scanner.nextLine());

        return new Motorbike(numberPlate, manufacturerName, manufactureYear, owner, power);
    }

    public static String inputNumberPlateForDelete() {
        System.out.println("Xóa xe máy");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }

    public static String inputNumberPlateForSearch() {
        System.out.println("Tìm xe máy");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }
    public static String inputNumberPlate(){
        System.out.println("nhập biển số xe");
        return scanner.nextLine();
    }
}
