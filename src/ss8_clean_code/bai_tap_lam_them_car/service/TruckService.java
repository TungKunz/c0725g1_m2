package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.TruckRepository;

import java.util.List;

public class TruckService implements IVehicleService<TruckEntity> {
    private IVehicleRepository<TruckEntity> truckRepository = new TruckRepository();

    @Override
    public List<TruckEntity> findAll() {
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

    @Override
    public boolean deleteById(String numberPlate) {
        return truckRepository.deleteById(numberPlate);
    }

    @Override
    public String getVehicleType() {
        return "xe tải";
    }
}
