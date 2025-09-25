package ss8_clean_code.bai_tap_lam_them_car.repository;

import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;
import ss8_clean_code.bai_tap_lam_them_car.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{


    private final String CAR_FILE="src/ss8_clean_code/bai_tap_lam_them_car/data/motorbike_file.csv";

    @Override
    public List<Motorbike> findAll() {

        List<Motorbike> motorbikeList = new ArrayList<>();
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
            int power = Integer.parseInt(array[4]);
            Motorbike motorbike = new Motorbike(numberPlate, manufacturerName, manufactureYear, owner,power);
            motorbikeList.add(motorbike);
        }
        return motorbikeList;
    }

    @Override
    public boolean add(Motorbike motorbike) {
        List<String> stringList = new ArrayList<>();
        stringList.add(motorbike.getInforToCSV());
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
        List<Motorbike> motorbikeList= findAll();
        if(findById(numberPlate)!=null){
            motorbikeList.remove(findById(numberPlate));
        }
        List<String> stringList = new ArrayList<>();
        for (Motorbike motorbike : motorbikeList) {
            stringList.add(motorbike.getInforToCSV());
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
    public Motorbike findById(String numberPlate) {
        List<Motorbike> motorbikeList=findAll();
        for (Motorbike motorbike: motorbikeList){
            if(motorbike.getNumberPlate().equals(numberPlate)){
                return motorbike;
            }
        }
        return null;
    }
}
