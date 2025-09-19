package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import ss8_clean_code.bai_tap_lam_them_car.repository.CarRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;

import java.util.List;

public class CarService implements IVehicleService<Car> {
    private IVehicleRepository<Car> carRepository = new CarRepository();

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void add(Car car) {
        carRepository.add(car);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return carRepository.deleteById(numberPlate);
    }

    @Override
    public int searchId(String numberPlate) {
        return carRepository.searchId(numberPlate);
    }

    @Override
    public void edit(Car newCarData, int index) {
        carRepository.edit(newCarData, index);
    }

    @Override
    public String getVehicleType() {
        return "ô tô";
    }
}
