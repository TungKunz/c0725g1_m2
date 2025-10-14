package DemoThi.validate;

public class CheckPerson {
    public static boolean checkId(String type, String id){
        if(type.equals("vietnam")){
            String regex= "^KHVN-\\d{4}$";
            return id.matches(regex);
        }else if(type.equals("foreign")){
            String regex="^KHNN-\\d{4}$";
            return id.matches(regex);
        }else {
            return false;
        }
    }
    public static boolean checkName(String name){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return name.matches(regex);
    }
}
