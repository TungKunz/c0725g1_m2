package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IVehicleRepository<Motorbike> {
    private static List<Motorbike> motorbikeEntities = new ArrayList<>();

    @Override
    public List<Motorbike> findAll() {
        return new ArrayList<>(motorbikeEntities);
    }

    @Override
    public int searchId(String numberPlate) {
        for (int i = 0; i < motorbikeEntities.size(); i++) {
            if (motorbikeEntities.get(i).getNumberPlate().equals(numberPlate)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(Motorbike vehicle, int index) {
        if (index >= 0 && index < motorbikeEntities.size()) {
            motorbikeEntities.set(index, vehicle);
        }
    }

    @Override
    public void add(Motorbike motorbike) {
        motorbikeEntities.add(motorbike);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return motorbikeEntities.removeIf(m -> m.getNumberPlate().equals(numberPlate));
    }
}
