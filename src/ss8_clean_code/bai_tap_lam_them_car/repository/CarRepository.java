package ss8_clean_code.bai_tap_lam_them_car.repository;


import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import ss8_clean_code.bai_tap_lam_them_car.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private final String CAR_FILE="src/ss8_clean_code/bai_tap_lam_them_car/data/car_file.csv";

    @Override
    public List<Car> findAll() {

        List<Car> carList = new ArrayList<>();
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
            int numberOfSeats = Integer.parseInt(array[4]);
            String carType = array[5];
            Car car = new Car(numberPlate, manufacturerName, manufactureYear, owner, numberOfSeats, carType);
            carList.add(car);
        }
        return carList;
    }

    @Override
    public boolean add(Car car) {
        List<String> stringList = new ArrayList<>();
        stringList.add(car.getInforToCSV());
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
        List<Car> carList= findAll();
        for (int i = 0; i <carList.size() ; i++) {
            if (carList.get(i).getNumberPlate().equals(numberPlate)){
                carList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Car car : carList) {
            stringList.add(car.getInforToCSV());
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
    public Car findById(String numberPlate) {
        List<Car> carList=findAll();
        for (Car car: carList){
            if(car.getNumberPlate().equals(numberPlate)){
                return car;
            }
        }
        return null;
    }
}
