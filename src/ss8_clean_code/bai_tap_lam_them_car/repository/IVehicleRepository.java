package ss8_clean_code.bai_tap_lam_them_car.repository;

public interface IVehicleRepository<T> {
    void add(T vehicle);
    boolean deleteById(String numberPlate);
    T[] findAll();
    int searchId(String numberPlate);
    void edit(T vehicle, int index);
}
