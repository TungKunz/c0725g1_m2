package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<CarEntity> {
    private static List<CarEntity> carEntities = new ArrayList<>();

    @Override
    public List<CarEntity> findAll() {
        return new ArrayList<>(carEntities); // trả bản copy tránh lỗi ngoài ý muốn
    }

    @Override
    public void add(CarEntity car) {
        carEntities.add(car);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return carEntities.removeIf(c -> c.getNumberPlate().equals(numberPlate));
    }

    @Override
    public int searchId(String numberPlate) {
        for (int i = 0; i < carEntities.size(); i++) {
            if (carEntities.get(i).getNumberPlate().equals(numberPlate)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(CarEntity vehicle, int index) {
        if (index >= 0 && index < carEntities.size()) {
            carEntities.set(index, vehicle);
        }
    }
}
