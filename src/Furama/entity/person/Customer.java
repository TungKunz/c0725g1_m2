package Furama.entity.person;

import java.time.LocalDate;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String customerType, String address) {
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String idPerson, String namePerson, LocalDate dateOfBirthPerson, byte genderPerson, String identityNumberPerson, String phoneNumberPerson, String emailPerson, String customerType, String address) {
        super(idPerson, namePerson, dateOfBirthPerson, genderPerson, identityNumberPerson, phoneNumberPerson, emailPerson);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idPerson=" + getIdPerson() +
                ", namePerson='" + getNamePerson() + '\'' +
                ", dateOfBirthPerson=" + getDateOfBirthPerson() +
                ", genderPerson=" + getGenderPerson() +
                ", identityNumberPerson=" + getIdentityNumberPerson() +
                ", phoneNumberPerson=" + getPhoneNumberPerson() +
                ", emailPerson='" + getEmailPerson() + '\'' +
                "customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
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
                + this.getCustomerType() + ","
                + this.getAddress();
    }
}
