package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;

public interface ITruckRepository {
    TruckEntity[] findAll();
    void add (TruckEntity truck);
    boolean deleteById(String numberPlate);

}
