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
    private static IVehicleService<CarEntity> carManager = new CarService();
    private static IVehicleService<TruckEntity> truckManager = new TruckService();
    private static IVehicleService<MotorbikeEntity> motorbikeManager = new MotorbikeService();


    private static CarEntity carEntity = new CarEntity();

    public static void showMenu() {
        while (true) {
            System.out.println("==== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG ====");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm phương tiện");
            System.out.println("5. Sửa thông tin phương tiện");
            System.out.println("6. Thoát");
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
                    showSearchVehicle();
                    break;
                case 5:
                    showEditVehicle();
                    break;
                case 6:
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
        System.out.print("Nhập biển kiểm soát cần xóa: ");
        String numberPlate = scanner.nextLine();
        IVehicleService<?>[] services = new IVehicleService[]{carManager, truckManager, motorbikeManager};
        for (IVehicleService<?> service : services) {
            int index = service.searchId(numberPlate);
            if (index != -1) {
                String vehicleType = "";
                if (service instanceof CarService) vehicleType = "ô tô";
                else if (service instanceof TruckService) vehicleType = "xe tải";
                else if (service instanceof MotorbikeService) vehicleType = "xe máy";

                System.out.print("Tìm thấy " + vehicleType + " có BKS " + numberPlate + ". Bạn có chắc muốn xóa? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Yes")) {
                    service.deleteById(numberPlate);
                    System.out.println("Đã xóa " + vehicleType + " thành công!");
                } else {
                    System.out.println("Hủy thao tác.");
                }
                return;
            }
        }

        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
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

    static void showSearchVehicle() {
        System.out.print("Nhập biển kiểm soát cần tìm: ");
        String numberPlate = scanner.nextLine();

        IVehicleService<?>[] services = new IVehicleService[]{carManager, truckManager, motorbikeManager};

        for (IVehicleService<?> service : services) {
            int index = service.searchId(numberPlate);
            if (index != -1) {
                Object[] vehicles = service.findAll();
                Object vehicle = vehicles[index];
                System.out.println("Tìm thấy " + service.getVehicleType() + " có BKS " + numberPlate);
                System.out.println(vehicle.toString());
                return;
            }

        }

        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
    }

    static void showEditVehicle() {
        System.out.print("Nhập biển kiểm soát cần sửa: ");
        String numberPlate = scanner.nextLine();

        IVehicleService<?>[] services = new IVehicleService[]{carManager, truckManager, motorbikeManager};

        for (IVehicleService<?> service : services) {
            int index = service.searchId(numberPlate);
            if (index != -1) {
                String vehicleType = "";
                if (service instanceof CarService) {
                    vehicleType = "ô tô";
                    CarEntity[] cars = ((CarService) service).findAll();
                    CarEntity oldCar = cars[index];
                    System.out.println("Thông tin cũ: " + oldCar);

                    CarEntity newCarData = CarView.inputDataForCar();
                    newCarData.setNumberPlate(oldCar.getNumberPlate()); // giữ nguyên biển số
                    ((CarService) service).edit(newCarData, index);

                } else if (service instanceof TruckService) {
                    vehicleType = "xe tải";
                    TruckEntity[] trucks = ((TruckService) service).findAll();
                    TruckEntity oldTruck = trucks[index];
                    System.out.println("Thông tin cũ: " + oldTruck);

                    TruckEntity newTruckData = TruckView.inputDataForTruck();
                    newTruckData.setNumberPlate(oldTruck.getNumberPlate());
                    ((TruckService) service).edit(newTruckData, index);

                } else if (service instanceof MotorbikeService) {
                    vehicleType = "xe máy";
                    MotorbikeEntity[] motors = ((MotorbikeService) service).findAll();
                    MotorbikeEntity oldMotor = motors[index];
                    System.out.println("Thông tin cũ: " + oldMotor);

                    MotorbikeEntity newMotorData = MotorbikeView.inputDataForMotorbike();
                    newMotorData.setNumberPlate(oldMotor.getNumberPlate());
                    ((MotorbikeService) service).edit(newMotorData, index);
                }

                System.out.println("Đã cập nhật thông tin " + vehicleType + " thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
    }
}

