package bai_thi.validate;

public class CheckBenhAn {
    public static boolean kiemTraMa(String ma){
        String regex="^BA-\\d{3}$";
        return ma.matches(regex);
    }
    public static boolean kiemTraTen(String ten){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return ten.matches(regex);
    }
    public static boolean kiemTraNgay(String ngay){
        String regex="^\\d{2}/\\d{2}/\\d{4}$";
        return ngay.matches(regex);
    }
}
