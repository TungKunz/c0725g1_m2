package Furama.entity.person;

import java.time.LocalDate;

public class Employee extends Person{
    private String educationLevel;
    private String position;
    private int salary;
    public Employee(){}
    public Employee(String idPerson, String namePerson, LocalDate dateOfBirthPerson, byte genderPerson, String identityNumberPerson, String phoneNumberPerson, String emailPerson, String educationLevel, String position, int salary) {
        super(idPerson, namePerson, dateOfBirthPerson, genderPerson, identityNumberPerson, phoneNumberPerson, emailPerson);
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary;
    }

    private String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    private String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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

    @Override
    public String getInforToCSV() {
        return this.getIdPerson() + ","
                + this.getNamePerson() + ","
                + this.getDateOfBirthPerson() + ","
                + this.getGenderPerson() + ","
                + this.getIdentityNumberPerson() + ","
                + this.getPhoneNumberPerson() + ","
                + this.getEmailPerson() + ","
                + this.getEducationLevel() + ","
                + this.getPosition() + ","
                + this.getSalary();
    }
}
