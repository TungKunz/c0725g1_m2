package bai_thi.entity;

import java.time.LocalDate;

public class BenhNhanThuong extends BenhAn{
    private double phiNamVien;

    public BenhNhanThuong() {
    }

    public BenhNhanThuong(int stt, String maBenhAn, String ten, LocalDate ngayNhapVien, LocalDate ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(stt, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhNhanThuong{" +super.toString()+
                "phiNamVien=" + phiNamVien +
                '}';
    }

    @Override
    public String thongTinCSV() {
        return "thuong"+","+
                super.getStt()+","+
                super.getMaBenhAn()+","+
                super.getTen()+","+
                super.getNgayNhapVien()+","+
                super.getNgayRaVien()+","+
                super.getLyDoNhapVien()+","+
                this.getPhiNamVien();
    }
}
