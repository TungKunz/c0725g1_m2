package Furama.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CheckPerson {
    public static boolean checkId(String type, String id){
        if(type.equals("employee")){
            String regex="NV-\\d{4}";
            return id.matches(regex);
        }else if(type.equals("customer")){
            String regex="KH-\\d{4}";
            return id.matches(regex);
        }
        return false;
    }
    public static boolean checkName(String name){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(regex);
    }
    public static boolean checkIdentityNumber(String identityNumber){
        String regex="\\d{9}|\\d{12}";
        return identityNumber.matches(regex);
    }
    public static boolean checkBirthDate(String birthDateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            if (birthDate.isAfter(LocalDate.now())) {
                return false;
            }
            return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkPhoneNumber(String phone){
        String regex= "0\\d{9}";
        return phone.matches(regex);
    }
    public static boolean checkEmail(String email){
        String regex="^[A-Za-z0-9_]+@gmail\\.com$";
        return email.matches(regex);
    }
}
