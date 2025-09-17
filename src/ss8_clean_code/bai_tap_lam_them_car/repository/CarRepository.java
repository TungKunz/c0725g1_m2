package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.CarEntity;

public class CarRepository implements ICarRepository{
    private static  CarEntity[] carEntities = new CarEntity[100];
    @Override
    public CarEntity[] findAll(){
        // dọc file
        return carEntities;
    }

    @Override
    public void add (CarEntity car){
        // ghi file
        for (int i = 0; i <carEntities.length ; i++) {
            if (carEntities[i]==null){
                carEntities[i]= car;
                break;
            }
        }
    }

    @Override
    public boolean deleteById(String numberPlate) {
        boolean check = false;
        for (int i = 0; i < carEntities.length; i++) {
            if (carEntities[i] != null && carEntities[i].getNumberPlate().equals(numberPlate)) {
                for (int j = i; j < carEntities.length - 1; j++) {
                    carEntities[j] = carEntities[j + 1];
                }
                carEntities[carEntities.length - 1] = null;
                check = true;
                break;
            }
        }
        return check;
    }
}
