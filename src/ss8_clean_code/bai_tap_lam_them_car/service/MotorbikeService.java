package ss8_clean_code.bai_tap_lam_them_car.service;


import ss8_clean_code.bai_tap_lam_them_car.entity.Motorbike;

import ss8_clean_code.bai_tap_lam_them_car.repository.IVehicleRepository;
import ss8_clean_code.bai_tap_lam_them_car.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IMotorbikeService{
    private IVehicleRepository<Motorbike> motorbikeRepository = new MotorbikeRepository();

    @Override
    public List<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public boolean add(Motorbike motorbike) {
//        List<Student> studentList = studentRepository.findAll();
//        if (studentList.isEmpty()){
//            student.setId(1);
//        }else {
//            Student endStudent = studentList.get(studentList.size()-1);
//            student.setId(endStudent.getId()+1);
//        }
//
//        studentRepository.add(student);
        return motorbikeRepository.add(motorbike);
    }

    @Override
    public boolean deleteById(String numberPlate) {
         Motorbike motorbike = motorbikeRepository.findById(numberPlate);
        if(motorbike == null){
            return false;
        }
        return motorbikeRepository.deleteById(numberPlate);
    }

    @Override
    public Motorbike findById(String numberPlate) {
        return motorbikeRepository.findById(numberPlate);
    }
}
