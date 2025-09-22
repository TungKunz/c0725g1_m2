package Furama.repository;

import Furama.entity.person.Employee;

import java.util.List;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void add(Employee employee){
        employeeList.add(employee);
    }

    @Override
    public List<Employee> getList() {
        return employeeList;
    }

    @Override
    public void edit(Employee employee, int index) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.set(index, employee);
        }
    }

    @Override
    public int searchId(String numberPlate) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdPerson().equals(numberPlate)) {
                return i;
            }
        }
        return -1;
    }

}
