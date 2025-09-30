package Furama.entity.person;
import java.time.LocalDate;

public abstract class Person {
    private String idPerson;
    private String namePerson;
    private LocalDate dateOfBirthPerson;
    private byte genderPerson;
    private String identityNumberPerson;
    private String phoneNumberPerson;
    private String emailPerson;
    Person(){}

    public Person(String idPerson, String namePerson, LocalDate dateOfBirthPerson, byte genderPerson, String identityNumberPerson, String phoneNumberPerson, String emailPerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.dateOfBirthPerson = dateOfBirthPerson;
        this.genderPerson = genderPerson;
        this.identityNumberPerson = identityNumberPerson;
        this.phoneNumberPerson = phoneNumberPerson;
        this.emailPerson = emailPerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public LocalDate getDateOfBirthPerson() {
        return dateOfBirthPerson;
    }

    public void setDateOfBirthPerson(LocalDate dateOfBirthPerson) {
        this.dateOfBirthPerson = dateOfBirthPerson;
    }

    public byte getGenderPerson() {
        return genderPerson;
    }

    public void setGenderPerson(byte genderPerson) {
        this.genderPerson = genderPerson;
    }

    public String getIdentityNumberPerson() {
        return identityNumberPerson;
    }

    public void setIdentityNumberPerson(String identityNumberPerson) {
        this.identityNumberPerson = identityNumberPerson;
    }

    public String getPhoneNumberPerson() {
        return phoneNumberPerson;
    }

    public void setPhoneNumberPerson(String phoneNumberPerson) {
        this.phoneNumberPerson = phoneNumberPerson;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public void setEmailPerson(String emailPerson) {
        this.emailPerson = emailPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", namePerson='" + namePerson + '\'' +
                ", dateOfBirthPerson='" + dateOfBirthPerson + '\'' +
                ", genderPerson=" + genderPerson +
                ", identityNumberPerson=" + identityNumberPerson +
                ", phoneNumberPerson=" + phoneNumberPerson +
                ", emailPerson='" + emailPerson + '\'' +
                '}';
    }
    public abstract String getInforToCSV();
}
