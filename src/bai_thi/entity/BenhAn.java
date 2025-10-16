package bai_thi.entity;

import java.time.LocalDate;
import java.util.Locale;

public abstract class BenhAn {
    private int stt;
    private String maBenhAn;
    private String ten;
    private LocalDate ngayNhapVien;
    private LocalDate ngayRaVien;
    private String lyDoNhapVien;
    public BenhAn(){}
    public BenhAn(int stt, String maBenhAn, String ten, LocalDate ngayNhapVien, LocalDate ngayRaVien, String lyDoNhapVien) {
        this.stt = stt;
        this.maBenhAn = maBenhAn;
        this.ten = ten;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(LocalDate ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public LocalDate getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(LocalDate ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    @Override
    public String toString() {
        return
                "stt=" + stt +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", ten='" + ten + '\'' +
                ", ngayNhapVien=" + ngayNhapVien +
                ", ngayRaVien=" + ngayRaVien +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'';
    }
    public abstract String thongTinCSV();
}
