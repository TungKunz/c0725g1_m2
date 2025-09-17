package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.IMotorbikeRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.MotorbikeRepository;

public class MotorbikeService implements IMotorbikeService{
    private IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();
    @Override
    public MotorbikeEntity[]  findAll(){
        return motorbikeRepository.findAll();
    }

    @Override
    public void add(MotorbikeEntity motorbike) {
        motorbikeRepository.add(motorbike);
    }

    // chức năng
    @Override
    public boolean deleteById(String numberPlate) {
        return motorbikeRepository.deleteById(numberPlate);
    }
}
