package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;

public class MotorbikeRepository implements IMotorbikeRepository{
    public static MotorbikeEntity[] motorbikeEntities=new MotorbikeEntity[100];
    @Override
    public MotorbikeEntity[] findAll() {
        return motorbikeEntities;
    }

    @Override
    public void add (MotorbikeEntity motorbike){
        // ghi file
        for (int i = 0; i <motorbikeEntities.length ; i++) {
            if (motorbikeEntities[i]==null){
                motorbikeEntities[i]= motorbike;
                break;
            }
        }
    }

    @Override
    public boolean deleteById(String numberPlate) {
        boolean check = false;
        for (int i = 0; i < motorbikeEntities.length; i++) {
            if (motorbikeEntities[i] != null && motorbikeEntities[i].getNumberPlate().equals(numberPlate)) {
                for (int j = i; j < motorbikeEntities.length - 1; j++) {
                    motorbikeEntities[j] = motorbikeEntities[j + 1];
                }
                motorbikeEntities[motorbikeEntities.length - 1] = null;
                check = true;
                break;
            }
        }
        return check;
    }
}
