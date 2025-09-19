package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;
import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {
    private static List<Truck> truckEntities = new ArrayList<>();

    @Override
    public List<Truck> findAll() {

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
    public void edit(Truck vehicle, int index) {
        if (index >= 0 && index < truckEntities.size()) {
            truckEntities.set(index, vehicle);
        }
    }

    @Override
    public void add(Truck truck) {

        truckEntities.add(truck);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return truckEntities.removeIf(
                t -> t.getNumberPlate().equals(numberPlate));
    }
}
