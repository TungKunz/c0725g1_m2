package bai3_nhan_su_cong_ty.entity;

public abstract class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private int namSinh;
    private String soDienThoai;

    public NhanVien() {
    }
    public NhanVien(String maNhanVien, String hoTen, int namSinh, String soDienThoai) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "Mã NV: " + maNhanVien +
                ", Họ tên: " + hoTen +
                ", Năm sinh: " + namSinh +
                ", SĐT: " + soDienThoai;
    }
    public abstract String thongTinCSV();
}
