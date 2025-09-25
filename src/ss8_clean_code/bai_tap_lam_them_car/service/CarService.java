package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Car;
import ss8_clean_code.bai_tap_lam_them_car.repository.CarRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.ICarRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;

import java.util.List;

public class CarService implements ICarService {
    private IVehicleRepository<Car> carRepository = new CarRepository();
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public boolean add(Car car) {
//        List<Student> studentList = studentRepository.findAll();
//        if (studentList.isEmpty()){
//            student.setId(1);
//        }else {
//            Student endStudent = studentList.get(studentList.size()-1);
//            student.setId(endStudent.getId()+1);
//        }
//
//        studentRepository.add(student);
        return carRepository.add(car);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        Car car = carRepository.findById(numberPlate);
        if(car == null){
            return false;
        }
        return carRepository.deleteById(numberPlate);
    }

    @Override
    public Car findById(String numberPlate) {
        return carRepository.findById(numberPlate);
    }
}
