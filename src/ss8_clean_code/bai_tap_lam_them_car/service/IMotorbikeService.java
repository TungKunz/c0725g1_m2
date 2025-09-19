package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;

public interface IMotorbikeService {
    Motorbike[] findAll();
    void add (Motorbike motorbike);
    boolean deleteById(String numberPlate);
}
