package bai_thi.view;

import bai_thi.entity.BenhNhanThuong;
import bai_thi.entity.BenhNhanVip;

import java.util.List;

public class BenhNhanThuongView extends BenhAnView{
    public static BenhNhanThuong nhapDuLieu(BenhNhanThuong benhNhanThuong){
        benhNhanThuong.setMaBenhAn(nhapMaBenhAn());
        benhNhanThuong.setTen(nhapTenBenhNhan());
        benhNhanThuong.setNgayNhapVien(ngayNhapVien());
        benhNhanThuong.setNgayRaVien(ngayRaVien(benhNhanThuong.getNgayNhapVien()));
        benhNhanThuong.setLyDoNhapVien(lyDoNhapVien());
        benhNhanThuong.setPhiNamVien(phiNamVien());
        return benhNhanThuong;

    }
    public static double phiNamVien(){
        while (true){
            System.out.println("Nhập viện phí");
            double vienPhi= Double.parseDouble(scanner.nextLine());
            if(vienPhi > 0) return vienPhi;
            System.out.println("Viện phí phải > 0");
        }
    }

}
