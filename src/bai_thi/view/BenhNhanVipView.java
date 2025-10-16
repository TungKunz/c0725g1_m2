package bai_thi.view;


import bai_thi.entity.BenhNhanVip;
import bai_thi.validate.CheckBenhAn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BenhNhanVipView extends BenhAnView{
    private static final String[] goiVip = {"VIP I", "VIP II", "VIP III"};
    public static BenhNhanVip nhapDuLieu(BenhNhanVip benhNhanVip){
        benhNhanVip.setMaBenhAn(nhapMaBenhAn());
        benhNhanVip.setTen(nhapTenBenhNhan());
        benhNhanVip.setNgayNhapVien(ngayNhapVien());
        benhNhanVip.setNgayRaVien(ngayRaVien(benhNhanVip.getNgayNhapVien()));
        benhNhanVip.setLyDoNhapVien(lyDoNhapVien());
        benhNhanVip.setLoaiVIP(nhapGoiVip());
        benhNhanVip.setThoiHan(thoiHanVip());
        return benhNhanVip;
    }
    private static String nhapGoiVip() {
        while (true) {
            System.out.println("""
                    Các gói VIP
                    1. VIP I
                    2. VIP II
                    3. VIP III
                   """);
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 1 && index <= goiVip.length) {
                    return goiVip[index - 1];
                } else {
                    System.out.println("Không hợp lệ, nhập chữ số từ 1->3 tương ứng gói VIP");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ, nhập chữ số từ 1->4 tương ứng VIP");
            }

        }
    }
    private static LocalDate thoiHanVip(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày hết hạn gói VIP (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                if (CheckBenhAn.kiemTraNgay(input)) {
                    return LocalDate.parse(input, formatter);
                } else {
                    System.out.println("Định dạng ngày không đúng (dd/MM/yyyy). Thử lại!");
                }

            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Thử lại!");
            }
        }
    }

}
