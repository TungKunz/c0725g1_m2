package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.ITruckRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.TruckRepository;

public class TruckService implements ITruckService{
    private ITruckRepository motorbikeRepository = new TruckRepository();
    @Override
    public TruckEntity[]  findAll(){
        return motorbikeRepository.findAll();
    }

    @Override
    public void add(TruckEntity truck) {
        motorbikeRepository.add(truck);
    }

    // chức năng
    @Override
    public boolean deleteById(String numberPlate) {
        return motorbikeRepository.deleteById(numberPlate);
    }
}
