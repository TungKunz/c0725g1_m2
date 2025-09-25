package ss8_clean_code.bai_tap_lam_them_car.service;

import java.util.List;

public interface IVehicleService<T> {
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(String numberPlate);
    T findById(String numberPlate);
}
