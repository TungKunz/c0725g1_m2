package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car> {
    private static List<Car> carEntities = new ArrayList<>();

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carEntities);
    }

    @Override
    public void add(Car car) {

        carEntities.add(car);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        return carEntities.removeIf(
                car -> car.getNumberPlate().equals(numberPlate));
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
    public void edit(Car vehicle, int index) {
        if (index >= 0 && index < carEntities.size()) {
            carEntities.set(index, vehicle);
        }
    }
}
