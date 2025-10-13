package bai3_nhan_su_cong_ty.view;

import bai3_nhan_su_cong_ty.validate.KiemTra;

import java.util.Scanner;

public class NhanVienView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nhapMa() {
        System.out.println("Nhập mã nhân viên ");
        return scanner.nextLine();
    }

    public static String nhapHoTen() {
        while (true) {
            System.out.println("Nhập họ và tên nhân viên ");
            String ten = scanner.nextLine();
            if (KiemTra.kiemTraTen(ten)) {
                return ten;
            }
            System.out.println("Nhập sai định dạng cho tên mời bạn nhập lại");
        }

    }

    public static int nhapNamSinh() {
        while (true) {
            System.out.println("Nhập năm sinh ");
            int namSinh = Integer.parseInt(scanner.nextLine());
            if (namSinh > 1900 && namSinh < 2026) {
                return namSinh;
            }
            System.out.println("Năm sinh bạn nhập không hợp lệ");
        }
    }

    public static String nhapSoDienThoai() {
        while (true) {
            System.out.println("Nhập số điện thoại ");
            String sdt= scanner.nextLine();
            if(KiemTra.kiemTraSoDienThoai(sdt)){
                return sdt;
            }
            System.out.println("Nhập số điện thoại không hợp lệ");
        }

    }
}
