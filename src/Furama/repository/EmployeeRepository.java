package Furama.repository;

import Furama.entity.person.Employee;
import Furama.util.ReadAndWriteFile;
import Furama.validate.CheckPerson;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String EMPLOYEE_FILE = "D:\\CodeGym\\Module2\\src\\Furama\\data\\person.csv";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = ReadAndWriteFile.readFileCSVToList(EMPLOYEE_FILE);
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
        String[] array;
        int lineException=0;
        for (String line : stringList) {
            try {
                lineException++;
                array = line.split(",");
                if(CheckPerson.checkId("employee",array[0])){
                    String idPerson = array[0];
                    String namePerson = array[1];
                    LocalDate dateOfBirthPerson = LocalDate.parse(array[2]);
                    byte genderPerson = Byte.parseByte(array[3]);
                    String identityNumberPerson = array[4];
                    String phoneNumberPerson = array[5];
                    String emailPerson = array[6];
                    String educationLevel = array[7];
                    String position = array[8];
                    int salary = Integer.parseInt(array[9]);
                    Employee employee = new Employee(idPerson, namePerson, dateOfBirthPerson, genderPerson, identityNumberPerson, phoneNumberPerson, emailPerson, educationLevel, position, salary);
                    employeeList.add(employee);
                }
            } catch (Exception e) {
                System.out.println("Lỗi gì sai định dạng class tại dòng " +lineException);
            }
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        List<String> stringList = new ArrayList<>();
        stringList.add(employee.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(EMPLOYEE_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Employee deleteEmployee) {
        List<Employee> employeeList = findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdPerson().equals(deleteEmployee.getIdPerson())) {
                employeeList.remove(i);
                break;
            }
        }
        return writeFileList(employeeList);
    }

    @Override
    public boolean editById(Employee editEmployee) {
        List<Employee> employeeList = findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdPerson().equals(editEmployee.getIdPerson())) {
                employeeList.set(i, editEmployee);
                break;
            }
        }
        return writeFileList(employeeList);
    }

    @Override
    public Employee findById(String idPerson) {
        List<Employee> employeeList = findAll();
        for (Employee employee : employeeList) {
            if (employee.getIdPerson().equals(idPerson)) {
                return employee;
            }
        }
        return null;
    }
    public boolean writeFileList(List<Employee> employeeList){
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(EMPLOYEE_FILE, stringList, false);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }
}
