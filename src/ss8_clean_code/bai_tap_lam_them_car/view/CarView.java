package ss8_clean_code.bai_tap_lam_them_car.view;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;

import java.util.Scanner;

public class CarView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(CarEntity[] carEntities) {
        System.out.printf("%-12s | %-15s | %-10s | %-15s | %-5s | %-10s\n",
                "Biển số", "Hãng SX", "Năm SX", "Chủ sở hữu", "Số chỗ", "Kiểu xe");
        System.out.println("-----------------------------------------------------------------------");

        for (CarEntity car : carEntities) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }

    public static CarEntity inputDataForCar(){
        System.out.println("Thêm mới");
        System.out.println("Nhập biển kiểm soát");
        String numberPlate=scanner.nextLine();
        System.out.println("Nhập tên hãng sản xuất");
        String manufacturerName=scanner.nextLine();
        System.out.println("Nhập năm sản xuất ");
        int manufactureYear=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu ");
        String owner=scanner.nextLine();
        System.out.println("Nhập số chỗ ngồi ");
        int numberOfSeats=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe ");
        String carType=scanner.nextLine();
        return new CarEntity(numberPlate,manufacturerName,manufactureYear,owner,numberOfSeats,carType);
    }
    public static String inputNumberPlateForDelete() {
        System.out.println("Xóa xe");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }

}
