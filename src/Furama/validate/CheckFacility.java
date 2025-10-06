package Furama.validate;

public class CheckFacility {
    public static boolean checkId(String type, String id){
        if(type.equals("villa")){
            String regex="SVVL-\\d{4}";
            return id.matches(regex);
        }else if(type.equals("house")){
            String regex="SVHO-\\d{4}";
            return id.matches(regex);
        }else if(type.equals("room")){
            String regex="SVRO-\\d{4}";
            return id.matches(regex);
        }
        return false;
    }
    public static boolean checkName(String name){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(regex);
    }
}
