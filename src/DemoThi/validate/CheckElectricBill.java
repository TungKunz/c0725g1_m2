package DemoThi.validate;

public class CheckElectricBill {
    public static boolean checkDay(String day){
        String regex="^\\d{2}/\\d{2}/\\d{4}$";
        return day.matches(regex);
    }
}
