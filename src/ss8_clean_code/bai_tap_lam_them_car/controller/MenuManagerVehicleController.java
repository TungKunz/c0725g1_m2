package ss8_clean_code.bai_tap_lam_them_car.controller;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import ss8_clean_code.bai_tap_lam_them_car.service.*;
import ss8_clean_code.bai_tap_lam_them_car.view.CarView;
import ss8_clean_code.bai_tap_lam_them_car.view.MotorbikeView;
import ss8_clean_code.bai_tap_lam_them_car.view.TruckView;

import java.util.List;
import java.util.Scanner;

public class MenuManagerVehicleController {
    private static Scanner scanner = new Scanner(System.in);
    private static IVehicleService<CarEntity> carManager = new CarService();
    private static IVehicleService<TruckEntity> truckManager = new TruckService();
    private static IVehicleService<MotorbikeEntity> motorbikeManager = new MotorbikeService();

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
                case 1 -> showAddMenu();
                case 2 -> showDisplayMenu();
                case 3 -> showDeleteMenu();
                case 4 -> showSearchVehicle();
                case 5 -> showEditVehicle();
                case 6 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
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
            case 1 -> {
                TruckEntity truck = TruckView.inputDataForTruck();
                truckManager.add(truck);
                System.out.println("Thêm mới thành công");
            }
            case 2 -> {
                CarEntity car = CarView.inputDataForCar();
                carManager.add(car);
                System.out.println("Thêm mới thành công");
            }
            case 3 -> {
                MotorbikeEntity motorbike = MotorbikeView.inputDataForMotorbike();
                motorbikeManager.add(motorbike);
                System.out.println("Thêm mới thành công");
            }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    static void showDeleteMenu() {
        System.out.print("Nhập biển kiểm soát cần xóa: ");
        String numberPlate = scanner.nextLine();
        IVehicleService<?>[] services = new IVehicleService[]{carManager, truckManager, motorbikeManager};

        for (IVehicleService<?> service : services) {
            int index = service.searchId(numberPlate);
            if (index != -1) {
                String vehicleType = service.getVehicleType();

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
            case 1 -> {
                System.out.println("Danh sách xe tải");
                TruckView.showList(truckManager.findAll());
            }
            case 2 -> {
                System.out.println("Danh sách ô tô");
                CarView.showList(carManager.findAll());
            }
            case 3 -> {
                System.out.println("Danh sách xe máy");
                MotorbikeView.showList(motorbikeManager.findAll());
            }
        }
    }

    static void showSearchVehicle() {
        System.out.print("Nhập biển kiểm soát cần tìm: ");
        String numberPlate = scanner.nextLine();

        IVehicleService<?>[] services = new IVehicleService[]{carManager, truckManager, motorbikeManager};

        for (IVehicleService<?> service : services) {
            int index = service.searchId(numberPlate);
            if (index != -1) {
                List<?> vehicles = service.findAll();
                Object vehicle = vehicles.get(index);
                System.out.println("Tìm thấy " + service.getVehicleType() + " có BKS " + numberPlate);
                System.out.println(vehicle);
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
                String vehicleType = service.getVehicleType();

                if (service instanceof CarService carService) {
                    List<CarEntity> cars = carService.findAll();
                    CarEntity oldCar = cars.get(index);
                    System.out.println("Thông tin cũ: " + oldCar);

                    CarEntity newCarData = CarView.inputDataForCar();
                    newCarData.setNumberPlate(oldCar.getNumberPlate());
                    carService.edit(newCarData, index);

                } else if (service instanceof TruckService truckService) {
                    List<TruckEntity> trucks = truckService.findAll();
                    TruckEntity oldTruck = trucks.get(index);
                    System.out.println("Thông tin cũ: " + oldTruck);

                    TruckEntity newTruckData = TruckView.inputDataForTruck();
                    newTruckData.setNumberPlate(oldTruck.getNumberPlate());
                    truckService.edit(newTruckData, index);

                } else if (service instanceof MotorbikeService motorbikeService) {
                    List<MotorbikeEntity> motors = motorbikeService.findAll();
                    MotorbikeEntity oldMotor = motors.get(index);
                    System.out.println("Thông tin cũ: " + oldMotor);

                    MotorbikeEntity newMotorData = MotorbikeView.inputDataForMotorbike();
                    newMotorData.setNumberPlate(oldMotor.getNumberPlate());
                    motorbikeService.edit(newMotorData, index);
                }

                System.out.println("Đã cập nhật thông tin " + vehicleType + " thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
    }
}
