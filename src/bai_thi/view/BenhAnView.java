package bai_thi.view;

import bai_thi.entity.BenhAn;

import bai_thi.validate.CheckBenhAn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Scanner;

public class BenhAnView {
    public static final Scanner scanner = new Scanner(System.in);
    public static String nhapMaBenhAn(){
        while (true) {
            System.out.print("Nhập mã bệnh án (BA-XXX): ");
            String ma = scanner.nextLine();
            if (CheckBenhAn.kiemTraMa(ma)) return ma;
            System.out.println("Mã bệnh án không đúng định dạng. Thử lại!");
        }
    }
    public static String nhapTenBenhNhan(){
        while (true){
            System.out.println("Nhập tên bệnh nhân: ");
            String ten=scanner.nextLine();
            if(CheckBenhAn.kiemTraTen(ten)) return ten;
            System.out.println("Tên nhập không đúng, mời nhập lại");
        }
        }
    public static LocalDate ngayNhapVien(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        while (true) {
            try {
                System.out.print("Nhập ngày vào viện (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                if (CheckBenhAn.kiemTraNgay(input)) {
                    LocalDate date = LocalDate.parse(input, formatter);
                    if (date.isAfter(LocalDate.now())) {
                        System.out.println("Ngày vào viện không được lớn hơn ngày hiện tại. Thử lại!");
                        continue;
                    }
                    return date;
                } else {
                    System.out.println("Định dạng ngày không đúng (dd/MM/yyyy). Thử lại!");
                }

            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Thử lại!");
            }
        }
    }
    public static LocalDate ngayRaVien(LocalDate ngayNhapVien){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày ra viện (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                if (CheckBenhAn.kiemTraNgay(input)) {
                    LocalDate date = LocalDate.parse(input, formatter);
                    if (date.isAfter(LocalDate.now())) {
                        System.out.println("Ngày ra viện không được lớn hơn ngày hiện tại. Thử lại!");
                        continue;
                    }
                    if (date.isBefore(ngayNhapVien)) {
                        System.out.println("Ngày ra viện không được nhỏ hơn ngày nhập viện. Thử lại!");
                        continue;
                    }
                    return date;
                } else {
                    System.out.println("Định dạng ngày không đúng (dd/MM/yyyy). Thử lại!");
                }

            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Thử lại!");
            }
        }
    }
    public static String lyDoNhapVien(){
        System.out.println("Nhập lí do nhập viện");
        return scanner.nextLine();
    }
    public static void inThongTin(List<BenhAn> benhAnList){
        if(benhAnList.isEmpty()){
            System.out.println("Danh sách văn phòng trống ");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (BenhAn bn:benhAnList){
            System.out.println(bn);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
