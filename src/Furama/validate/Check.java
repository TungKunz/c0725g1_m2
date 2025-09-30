package Furama.validate;

public class CheckName {
    public static boolean checkName(String name){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(regex);
    }
}
