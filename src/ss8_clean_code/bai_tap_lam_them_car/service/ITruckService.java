package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;

public interface ITruckService {
    Truck[] findAll();
    void add (Truck truck);
    boolean deleteById(String numberPlate);
}
