package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;

public interface ICarRepository {
    CarEntity[] findAll();
    void add (CarEntity car);
    boolean deleteById(String numberPlate);
    int searchId(String numberPlate);
    void edit(CarEntity newCarData, int index);
}
