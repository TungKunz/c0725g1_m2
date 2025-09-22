package Furama.entity.person;

import java.time.LocalDate;

public class Employee extends Person{
    private String educationLevel;
    private String position;
    private int salary;
    public Employee(String idPerson, String namePerson, LocalDate dateOfBirthPerson, byte genderPerson, String identityNumberPerson, String phoneNumberPerson, String emailPerson, String educationLevel, String position, int salary) {
        super(idPerson, namePerson, dateOfBirthPerson, genderPerson, identityNumberPerson, phoneNumberPerson, emailPerson);
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary;
    }

    private String getEducationLevel() {
        return educationLevel;
    }

    private void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    private String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    private int getSalary() {
        return salary;
    }

    private void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idPerson=" + getIdPerson() +
                ", namePerson='" + getNamePerson() + '\'' +
                ", dateOfBirthPerson=" + getDateOfBirthPerson() +
                ", genderPerson=" + getGenderPerson() +
                ", identityNumberPerson=" + getIdentityNumberPerson() +
                ", phoneNumberPerson=" + getPhoneNumberPerson() +
                ", emailPerson='" + getEmailPerson() + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
