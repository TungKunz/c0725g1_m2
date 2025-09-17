package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;

public interface ICarService {
    CarEntity[] findAll();
    void add (CarEntity car);
    boolean deleteById(String numberPlate);
}
