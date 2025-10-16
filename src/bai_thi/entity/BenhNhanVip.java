package bai_thi.entity;

import java.time.LocalDate;

public class BenhNhanVip extends BenhAn{
    private String loaiVIP;
    private LocalDate thoiHan;

    public BenhNhanVip() {
    }

    public BenhNhanVip(int stt, String maBenhAn, String ten, LocalDate ngayNhapVien, LocalDate ngayRaVien, String lyDoNhapVien, String loaiVIP, LocalDate thoiHan) {
        super(stt, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVIP = loaiVIP;
        this.thoiHan = thoiHan;
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public LocalDate getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(LocalDate thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return "BenhNhanVip{" +super.toString()+
                "loaiVIP='" + loaiVIP + '\'' +
                ", thoiHan=" + thoiHan +
                '}';
    }
    @Override
    public String thongTinCSV() {
        return "vip"+","+
                super.getStt()+","+
                super.getMaBenhAn()+","+
                super.getTen()+","+
                super.getNgayNhapVien()+","+
                super.getNgayRaVien()+","+
                super.getLyDoNhapVien()+","+
                this.getLoaiVIP()+","+
                this.getThoiHan();
    }
}
