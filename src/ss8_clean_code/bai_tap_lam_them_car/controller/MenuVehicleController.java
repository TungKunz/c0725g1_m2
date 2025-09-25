package ss8_clean_code.bai_tap_lam_them_car.controller;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;
import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;
import ss8_clean_code.bai_tap_lam_them_car.service.*;
import ss8_clean_code.bai_tap_lam_them_car.view.CarView;
import ss8_clean_code.bai_tap_lam_them_car.view.MotorbikeView;
import ss8_clean_code.bai_tap_lam_them_car.view.TruckView;

import java.util.List;
import java.util.Scanner;

public class MenuVehicleController {
    private static Scanner scanner = new Scanner(System.in);
    private static IVehicleService<Car> carService = new CarService();
    private static IVehicleService<Truck> truckService = new TruckService();
    private static IVehicleService<Motorbike> motorbikeService = new MotorbikeService();

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
//                case 4 -> showSearchVehicle();
//                case 5 -> showEditVehicle();
                case 6 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
            }
        }
    }

    private static void showAddMenu() {
        System.out.println("1. Thêm xe tải");
        System.out.println("2. Thêm ô tô");
        System.out.println("3. Thêm xe máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1 -> {
                Truck truck = TruckView.inputDataForTruck();
                truckService.add(truck);
                System.out.println("Thêm mới thành công");
            }
            case 2 -> {
                Car car = CarView.inputDataForCar();

                carService.add(car);

                System.out.println("Thêm mới thành công");
            }
            case 3 -> {
                Motorbike motorbike = MotorbikeView.inputDataForMotorbike();
                motorbikeService.add(motorbike);
                System.out.println("Thêm mới thành công");
            }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void showDeleteMenu() {

        String numberPlate = CarView.inputNumberPlate();
        boolean isDeleteSuccessCar = carService.deleteById(numberPlate);
        if (isDeleteSuccessCar) {
                System.out.println("Đã xóa ô tô thành công!");
                return;
        }
        boolean isDeleteSuccessTruck = truckService.deleteById(numberPlate);
        if (isDeleteSuccessTruck) {
                System.out.println("Đã xóa ô tô thành công!");
                return;
        }
        boolean isDeleteSuccessMotorbike = motorbikeService.deleteById(numberPlate);
        if (isDeleteSuccessMotorbike) {
                System.out.println("Đã xóa ô tô thành công!");
                return;
        }

        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
    }


    private static void showDisplayMenu() {
        System.out.println("1. Hiển thị xe tải");
        System.out.println("2. Hiển thị ô tô");
        System.out.println("3. Hiển thị xe máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1 -> {
                System.out.println("Danh sách xe tải");
                List<Truck> truckList = truckService.findAll();
                TruckView.showList(truckList);
            }
            case 2 -> {
                System.out.println("Danh sách ô tô");
                List<Car> carList = carService.findAll();
                CarView.showList(carList);
            }
            case 3 -> {
                System.out.println("Danh sách xe máy");
                MotorbikeView.showList(motorbikeService.findAll());
            }
        }
    }

//    private static void showSearchVehicle() {
//        System.out.print("Nhập biển kiểm soát cần tìm: ");
//        String numberPlate = scanner.nextLine();
//
//        int carIndex = carService.searchId(numberPlate);
//        if (carIndex != -1) {
//            List<Car> cars = carService.findAll();
//            Car car = cars.get(carIndex);
//            System.out.println("Tìm thấy ô tô có BKS " + numberPlate);
//            System.out.println(car);
//            return;
//        }
//
//        int truckIndex = truckManager.searchId(numberPlate);
//        if (truckIndex != -1) {
//            List<Truck> trucks = truckManager.findAll();
//            Truck truck = trucks.get(truckIndex);
//            System.out.println("Tìm thấy xe tải có BKS " + numberPlate);
//            System.out.println(truck);
//            return;
//        }
//
//        int motorIndex = motorbikeManager.searchId(numberPlate);
//        if (motorIndex != -1) {
//            List<Motorbike> motors = motorbikeManager.findAll();
//            Motorbike motor = motors.get(motorIndex);
//            System.out.println("Tìm thấy xe máy có BKS " + numberPlate);
//            System.out.println(motor);
//            return;
//        }
//
//        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
//    }
//
//
//    private static void showEditVehicle() {
//        System.out.print("Nhập biển kiểm soát cần sửa: ");
//        String numberPlate = scanner.nextLine();
//
//        int carIndex = carService.searchId(numberPlate);
//        if (carIndex != -1) {
//            List<Car> cars = carService.findAll();
//            Car oldCar = cars.get(carIndex);
//            System.out.println("Thông tin cũ: " + oldCar);
//            Car newCarData = CarView.inputDataForCar();
//            newCarData.setNumberPlate(oldCar.getNumberPlate());
//            carService.edit(newCarData, carIndex);
//            System.out.println("Đã cập nhật thông tin ô tô thành công!");
//            return;
//        }
//
//        int truckIndex = truckManager.searchId(numberPlate);
//        if (truckIndex != -1) {
//            List<Truck> trucks = truckManager.findAll();
//            Truck oldTruck = trucks.get(truckIndex);
//            System.out.println("Thông tin cũ: " + oldTruck);
//
//            Truck newTruckData = TruckView.inputDataForTruck();
//            newTruckData.setNumberPlate(oldTruck.getNumberPlate());
//            truckManager.edit(newTruckData, truckIndex);
//
//            System.out.println("Đã cập nhật thông tin xe tải thành công!");
//            return;
//        }
//
//        int motorIndex = motorbikeManager.searchId(numberPlate);
//        if (motorIndex != -1) {
//            List<Motorbike> motors = motorbikeManager.findAll();
//            Motorbike oldMotor = motors.get(motorIndex);
//            System.out.println("Thông tin cũ: " + oldMotor);
//
//            Motorbike newMotorData = MotorbikeView.inputDataForMotorbike();
//            newMotorData.setNumberPlate(oldMotor.getNumberPlate());
//            motorbikeManager.edit(newMotorData, motorIndex);
//
//            System.out.println("Đã cập nhật thông tin xe máy thành công!");
//            return;
//        }
//
//        System.out.println("Không tìm thấy phương tiện có biển số: " + numberPlate);
//    }

}
