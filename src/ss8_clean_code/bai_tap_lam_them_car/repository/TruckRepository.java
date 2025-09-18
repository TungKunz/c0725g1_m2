package ss8_clean_code.bai_tap_lam_them_car.repository;
import ss8_clean_code.bai_tap_lam_them_car.entity.MotorbikeEntity;
import ss8_clean_code.bai_tap_lam_them_car.entity.TruckEntity;

public class TruckRepository implements IVehicleRepository<TruckEntity>{
    public static TruckEntity[] truckEntities=new TruckEntity[100];
    public static int size=0;
    @Override
    public TruckEntity[] findAll() {
        return truckEntities;
    }

    @Override
    public int searchId(String numberPlate) {
        int index = -1;
        for (int i = 0; i < truckEntities.length; i++) {
            if (truckEntities[i] != null && truckEntities[i].getNumberPlate().equals(numberPlate)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void edit(TruckEntity vehicle, int index) {
        if (index >= 0 && index < truckEntities.length && truckEntities[index] != null) {
            truckEntities[index] = vehicle;
        }
    }


    @Override
    public void add (TruckEntity truck){
        // ghi file
        for (int i = 0; i <truckEntities.length ; i++) {
            if (truckEntities[i]==null){
                truckEntities[i]= truck;
                break;
            }
        }
    }

    @Override
    public boolean deleteById(String numberPlate) {
        boolean check = false;
        for (int i = 0; i < truckEntities.length; i++) {
            if (truckEntities[i] != null && truckEntities[i].getNumberPlate().equals(numberPlate)) {
                for (int j = i; j < truckEntities.length - 1; j++) {
                    truckEntities[j] = truckEntities[j + 1];
                }
                truckEntities[truckEntities.length - 1] = null;
                check = true;
                break;
            }
        }
        return check;
    }
}
