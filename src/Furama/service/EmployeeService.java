package Furama.service;

import Furama.entity.person.Employee;
import Furama.repository.EmployeeRepository;
import Furama.repository.IRepository;


import java.util.List;

public class EmployeeService implements IService<Employee> {
    private final IRepository<Employee> employeeRepository = new EmployeeRepository();


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }

    @Override
    public boolean deleteById(Employee employee) {
        Employee checkEmployee = employeeRepository.findById(employee.getIdPerson());
        if(checkEmployee == null){
            return false;
        }
        return employeeRepository.deleteById(employee);
    }

    @Override
    public boolean editById(Employee employee) {
        Employee checkEmployee = employeeRepository.findById(employee.getIdPerson());
        if(checkEmployee ==null){
            return false;
        }
        return employeeRepository.editById(employee);
    }

    @Override
    public Employee findById(String idPerson) {
        return employeeRepository.findById(idPerson);
    }
}
