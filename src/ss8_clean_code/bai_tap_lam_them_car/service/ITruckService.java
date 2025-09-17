package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;

public interface ITruckService {
    TruckEntity[] findAll();
    void add (TruckEntity truck);
    boolean deleteById(String numberPlate);
}
