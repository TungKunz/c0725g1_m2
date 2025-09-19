package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;

public interface ICarRepository {
    Car[] findAll();
    void add (Car car);
    boolean deleteById(String numberPlate);
    int searchId(String numberPlate);
    void edit(Car newCarData, int index);
}
