package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;

public interface ITruckRepository {
    Truck[] findAll();
    void add (Truck truck);
    boolean deleteById(String numberPlate);

}
