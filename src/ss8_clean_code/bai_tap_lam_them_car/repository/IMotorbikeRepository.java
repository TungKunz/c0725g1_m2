package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;

public interface IMotorbikeRepository {
    MotorbikeEntity[] findAll();
    void add (MotorbikeEntity motorbike);
    boolean deleteById(String numberPlate);
}
