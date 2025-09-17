package ss8_clean_code.bai_tap_lam_them_car.controller;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import ss8_clean_code.bai_tap_lam_them_car.service.*;
import ss8_clean_code.bai_tap_lam_them_car.view.CarView;
import ss8_clean_code.bai_tap_lam_them_car.view.MotorbikeView;
import ss8_clean_code.bai_tap_lam_them_car.view.TruckView;

import java.util.Scanner;

public class MenuManagerVehicleController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICarService carManager = new CarService();
    private static ITruckService truckManager = new TruckService();
    private static IMotorbikeService motorbikeManager = new MotorbikeService();

    public static void showMenu() {
        while (true) {
            System.out.println("==== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG ====");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    showDisplayMenu();
                    break;
                case 3:
                    showDeleteMenu();
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Vui lòng chọn lại!");
            }
        }
    }

    public static void showAddMenu() {
        System.out.println("1. Thêm xe tải");
        System.out.println("2. Thêm ô tô");
        System.out.println("3. Thêm xe máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                TruckEntity truck = TruckView.inputDataForTruck();
                truckManager.add(truck);
                System.out.println("Thêm mới thành công");
                break;
            case 2:
                CarEntity car = CarView.inputDataForCar();
                carManager.add(car);
                System.out.println("Thêm mới thành công");
                break;
            case 3:
                MotorbikeEntity motorbike = MotorbikeView.inputDataForMotorbike();
                motorbikeManager.add(motorbike);
                System.out.println("Thêm mới thành công");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    static void showDeleteMenu() {
        System.out.println("1. Xóa xe tải");
        System.out.println("2. Xóa ô tô");
        System.out.println("3. Xóa xe máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                String numberPlateDeleteTruck = TruckView.inputNumberPlateForDelete();
                boolean isDeletedTruck = truckManager.deleteById(numberPlateDeleteTruck);
                if (isDeletedTruck) {
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy xe có biển số: " + numberPlateDeleteTruck);
                }
                break;
            case 2:
                String numberPlateDeleteCar = CarView.inputNumberPlateForDelete();
                boolean isDeletedCar = carManager.deleteById(numberPlateDeleteCar);
                if (isDeletedCar) {
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy xe có biển số: " + numberPlateDeleteCar);
                }
                break;
            case 3:
                String numberPlateDeleteMotor = MotorbikeView.inputNumberPlateForDelete();
                boolean isDeletedMotor = carManager.deleteById(numberPlateDeleteMotor);
                if (isDeletedMotor) {
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy xe có biển số: " + numberPlateDeleteMotor);
                }
                break;
        }
    }

    static void showDisplayMenu() {
        System.out.println("1. Hiển thị xe tải");
        System.out.println("2. Hiển thị ô tô");
        System.out.println("3. Hiển thị xe máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                System.out.println("Danh sách");
                TruckEntity[] truckEntities = truckManager.findAll();
                TruckView.showList(truckEntities);
                break;
            case 2:
                System.out.println("Danh sách");
                CarEntity[] carEntities = carManager.findAll();
                CarView.showList(carEntities);
                break;
            case 3:
                System.out.println("Danh sách");
                MotorbikeEntity[] motorbikeEntities = motorbikeManager.findAll();
                MotorbikeView.showList(motorbikeEntities);
                break;
        }
    }


}

