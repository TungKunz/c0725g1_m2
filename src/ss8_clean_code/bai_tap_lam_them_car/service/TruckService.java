package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.ITruckRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.TruckRepository;

public class TruckService implements IVehicleService<TruckEntity> {
    private IVehicleRepository<TruckEntity> truckRepository = new TruckRepository();
    @Override
    public TruckEntity[]  findAll(){
        return truckRepository.findAll();
    }

    @Override
    public int searchId(String numberPlate) {
        return truckRepository.searchId(numberPlate);
    }

    @Override
    public void edit(TruckEntity newTruckData, int index) {
        truckRepository.edit(newTruckData, index);
    }

    @Override
    public void add(TruckEntity truck) {
        truckRepository.add(truck);
    }

    // chức năng
    @Override
    public boolean deleteById(String numberPlate) {
        return truckRepository.deleteById(numberPlate);
    }
    @Override
    public String getVehicleType() {
        return "xe tải";
    }

}
