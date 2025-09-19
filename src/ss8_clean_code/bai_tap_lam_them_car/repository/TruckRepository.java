package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;
import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<TruckEntity> {
    private static List<TruckEntity> truckEntities = new ArrayList<>();

    @Override
    public List<TruckEntity> findAll() {
        return new ArrayList<>(truckEntities);
    }

    @Override
    public int searchId(String numberPlate) {
        for (int i = 0; i < truckEntities.size(); i++) {
            if (truckEntities.get(i).getNumberPlate().equals(numberPlate)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(TruckEntity vehicle, int index) {
        if (index >= 0 && index < truckEntities.size()) {
            truckEntities.set(index, vehicle);
        }
    }

    @Override
    public void add(TruckEntity truck) {
        truckEntities.add(truck);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return truckEntities.removeIf(t -> t.getNumberPlate().equals(numberPlate));
    }
}
