package Furama.service;

import Furama.entity.person.Employee;
import Furama.repository.EmployeeRepository;
import Furama.repository.IRepository;

import java.util.List;

public class EmployeeService implements IService<Employee> {
    private IRepository<Employee> employeeRepository = new EmployeeRepository();

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.getList();
    }

    @Override
    public void edit(Employee employee, int index) {
        employeeRepository.edit(employee,index);
    }

    @Override
    public int searchId(String numberPlate) {
       return employeeRepository.searchId(numberPlate);
    }
}
