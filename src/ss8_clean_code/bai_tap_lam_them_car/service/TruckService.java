package ss8_clean_code.bai_tap_lam_them_car.service;

import ss8_clean_code.bai_tap_lam_them_car.entity.Truck;
import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.TruckRepository;

import java.util.List;

public class TruckService implements ITruckService {
    private IVehicleRepository<Truck> truckRepository = new TruckRepository();

    @Override
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public boolean add(Truck truck) {
//        List<Student> studentList = studentRepository.findAll();
//        if (studentList.isEmpty()){
//            student.setId(1);
//        }else {
//            Student endStudent = studentList.get(studentList.size()-1);
//            student.setId(endStudent.getId()+1);
//        }
//
//        studentRepository.add(student);
        return truckRepository.add(truck);
    }

    @Override
    public boolean deleteById(String numberPlate) {
        Truck truck = truckRepository.findById(numberPlate);
        if(truck == null){
            return false;
        }
        return truckRepository.deleteById(numberPlate);
    }

    @Override
    public Truck findById(String numberPlate) {
        return truckRepository.findById(numberPlate);
    }
}
