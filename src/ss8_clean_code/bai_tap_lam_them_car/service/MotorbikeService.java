package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IVehicleService<Motorbike> {
    private IVehicleRepository<Motorbike> motorbikeRepository = new MotorbikeRepository();

    @Override
    public List<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public int searchId(String numberPlate) {
        return motorbikeRepository.searchId(numberPlate);
    }

    @Override
    public void edit(Motorbike newMotorData, int index) {
        motorbikeRepository.edit(newMotorData, index);
    }

    @Override
    public void add(Motorbike motorbike) {
        motorbikeRepository.add(motorbike);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return motorbikeRepository.deleteById(numberPlate);
    }

    @Override
    public String getVehicleType() {
        return "xe máy";
    }
}
