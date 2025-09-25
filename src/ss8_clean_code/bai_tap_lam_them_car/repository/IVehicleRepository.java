package ss8_clean_code.bai_tap_lam_them_car.repository;

import java.util.List;

public interface IVehicleRepository<T> {
//    boolean add(T vehicle);
//    boolean deleteById(String numberPlate);
//    List<T> findAll();
//    int searchId(String numberPlate);
//    void edit(T vehicle, int index);
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(String numberPlate);
    T findById(String numberPlate);
}
