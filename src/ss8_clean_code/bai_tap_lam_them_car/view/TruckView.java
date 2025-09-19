package ss8_clean_code.bai_tap_lam_them_car.view;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;

import java.util.List;
import java.util.Scanner;

public class TruckView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Truck> trucks) {
        if (trucks.isEmpty()) {
            System.out.println("Danh sách xe tải trống!");
            return;
        }

        System.out.printf("%-12s | %-15s | %-10s | %-15s | %-10s\n",
                "Biển số", "Hãng SX", "Năm SX", "Chủ sở hữu", "Trọng tải");
        System.out.println("-----------------------------------------------------------------");

        for (Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    public static Truck inputDataForTruck() {
        System.out.println("Thêm mới xe tải");
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = scanner.nextLine();
        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập trọng tải của xe: ");
        int loadCapacity = Integer.parseInt(scanner.nextLine());

        return new Truck(numberPlate, manufacturerName, manufactureYear, owner, loadCapacity);
    }

    public static String inputNumberPlateForDelete() {
        System.out.println("Xóa xe tải");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }

    public static String inputNumberPlateForSearch() {
        System.out.println("Tìm xe tải");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }
}
