package bai3_nhan_su_cong_ty.validate;

public class KiemTra {
    public static boolean kiemTraTen(String ten){
        String regex= "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        return ten.matches(regex);
    }
    public static boolean kiemTraSoDienThoai(String sdt){
        String regex="^0\\d{9}$";
        return sdt.matches(regex);
    }
}
