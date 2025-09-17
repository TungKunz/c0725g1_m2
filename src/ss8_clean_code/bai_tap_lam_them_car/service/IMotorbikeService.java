package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;

public interface IMotorbikeService {
    MotorbikeEntity[] findAll();
    void add (MotorbikeEntity motorbike);
    boolean deleteById(String numberPlate);
}
