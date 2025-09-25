package ss8_clean_code.bai_tap_lam_them_car.view;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import ss8_clean_code.bai_tap_lam_them_car.service.CarService;
import ss8_clean_code.bai_tap_lam_them_car.service.ICarService;
import ss8_clean_code.bai_tap_lam_them_car.service.IVehicleService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CarView {
    private static Scanner scanner = new Scanner(System.in);
    private static final IVehicleService<Car> carService = new CarService();
    public static void showList(List<Car> carEntities) {
        if (carEntities.isEmpty()) {
            System.out.println("Danh sách xe trống!");
            return;
        }

        System.out.printf("%-12s | %-15s | %-10s | %-15s | %-5s | %-10s\n",
                "Biển số", "Hãng SX", "Năm SX", "Chủ sở hữu", "Số chỗ", "Kiểu xe");
        System.out.println("-------------------------------------------------------------------------------");

        for (Car car : carEntities) {
            System.out.println(car);
        }
    }

    public static Car inputDataForCar() {
        System.out.println("=== Thêm mới ô tô ===");
        String numberPlate;

        while (true) {
            System.out.print("Nhập biển kiểm soát: ");
            numberPlate = scanner.nextLine();
            if (carService.findById(numberPlate) != null) {
                System.out.println("Biển số xe đã tồn tại, mời bạn nhập lại!");
            } else {
                break;
            }
        }

        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = scanner.nextLine();


        int manufactureYear;
        while (true) {
            try {
                System.out.print("Nhập năm sản xuất: ");
                manufactureYear = Integer.parseInt(scanner.nextLine());
                if (manufactureYear < 1886 || manufactureYear > 2100) {
                    System.out.println("Năm sản xuất không hợp lệ, vui lòng nhập lại!");
                    continue;
                }
                if(Pattern.matches("\\d{4}",String.valueOf(manufactureYear))){
                    break;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Năm sản xuất phải là số nguyên, vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println(" Lỗi khác: " + e.getMessage());
            }
        }
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        int numberOfSeats;
        while (true) {
            try {
                System.out.print("Nhập số chỗ ngồi: ");
                numberOfSeats = Integer.parseInt(scanner.nextLine());
                if (numberOfSeats <= 0) {
                    System.out.println("Số chỗ ngồi phải lớn hơn 0, vui lòng nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số chỗ ngồi phải là số nguyên, vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println("Lỗi khác: " + e.getMessage());
            }
        }

        System.out.print("Nhập kiểu xe: ");
        String carType = scanner.nextLine();

        return new Car(numberPlate, manufacturerName, manufactureYear, owner, numberOfSeats, carType);
    }

    public static String inputNumberPlateForDelete() {
        System.out.println("Xóa xe");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }

    public static String inputNumberPlateForSearch() {
        System.out.println("Tìm xe");
        System.out.print("Nhập biển kiểm soát: ");
        return scanner.nextLine();
    }

    public static Car inputEditDataForCar() {
        System.out.println("Sửa thông tin xe");
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = scanner.nextLine();
        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập số chỗ ngồi: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu xe: ");
        String carType = scanner.nextLine();

        return new Car(numberPlate, manufacturerName, manufactureYear, owner, numberOfSeats, carType);
    }
    public static String inputNumberPlate(){
        System.out.println("nhập biển số xe");
        return scanner.nextLine();
    }
}
