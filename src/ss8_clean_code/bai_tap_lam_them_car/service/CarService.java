package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.CarRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.ICarRepository;

public class CarService implements ICarService{
    private ICarRepository carRepository = new CarRepository();
    @Override
    public CarEntity[]  findAll(){
        return carRepository.findAll();
    }

    @Override
    public void add(CarEntity car) {
        carRepository.add(car);
    }

    // chức năng
    @Override
    public boolean deleteById(String numberPlate) {
        return carRepository.deleteById(numberPlate);
    }
}
