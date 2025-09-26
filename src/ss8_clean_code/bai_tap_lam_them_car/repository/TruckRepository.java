package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;
import ss8_clean_code.bai_tap_lam_them_car.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements ITruckRepository{
    private final String CAR_FILE="src/ss8_clean_code/bai_tap_lam_them_car/data/truck_file.csv";

    @Override
    public List<Truck> findAll() {

        List<Truck> truckList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = ReadAndWriteFile.readFileCSVToList(CAR_FILE);
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }
        String[] array;
        for(String line : stringList){
            array=line.split(",");
            String numberPlate = array[0];
            String manufacturerName = array[1];
            int manufactureYear = Integer.parseInt(array[2]);
            String owner = array[3];
            int loadCapacity = Integer.parseInt(array[4]);
            Truck truck = new Truck(numberPlate, manufacturerName, manufactureYear, owner, loadCapacity);
            truckList.add(truck);
        }
        return truckList;
    }

    @Override
    public boolean add(Truck truck) {
        List<String> stringList = new ArrayList<>();
        stringList.add(truck.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(CAR_FILE,stringList,true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(String numberPlate) {
        List<Truck> truckList= findAll();
        for (int i = 0; i <truckList.size() ; i++) {
            if (truckList.get(i).getNumberPlate().equals(numberPlate)){
                truckList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Truck truck : truckList) {
            stringList.add(truck.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CAR_FILE,stringList,false);
        }catch (IOException e){
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public Truck findById(String numberPlate) {
        List<Truck> truckList=findAll();
        for (Truck truck: truckList){
            if(truck.getNumberPlate().equals(numberPlate)){
                return truck;
            }
        }
        return null;
    }
}
