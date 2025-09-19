package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IVehicleService<MotorbikeEntity> {
    private IVehicleRepository<MotorbikeEntity> motorbikeRepository = new MotorbikeRepository();

    @Override
    public List<MotorbikeEntity> findAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public int searchId(String numberPlate) {
        return motorbikeRepository.searchId(numberPlate);
    }

    @Override
    public void edit(MotorbikeEntity newMotorData, int index) {
        motorbikeRepository.edit(newMotorData, index);
    }

    @Override
    public void add(MotorbikeEntity motorbike) {
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
