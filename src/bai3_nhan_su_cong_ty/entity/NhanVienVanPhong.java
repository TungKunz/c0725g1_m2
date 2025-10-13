package bai3_nhan_su_cong_ty.entity;

public class NhanVienVanPhong extends NhanVien{
    private float soNgayLamViec;
    private float heSoLuong;

    public NhanVienVanPhong() {

    }
    public NhanVienVanPhong(String maNhanVien, String hoTen, int namSinh, String soDienThoai, float soNgayLamViec, float heSoLuong) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.soNgayLamViec = soNgayLamViec;
        this.heSoLuong = heSoLuong;
    }

    public float getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(float soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    @Override
    public String toString() {
        return "NhanVienVanPhong {" +super.toString()+
                " soNgayLamViec = " + soNgayLamViec +
                ", heSoLuong=" + heSoLuong +
                '}';
    }

    @Override
    public String thongTinCSV() {
        return "banhang" +","+
                super.getMaNhanVien()+","+
                super.getHoTen()+","+
                super.getNamSinh()+","+
                super.getSoDienThoai()+","+
                this.getSoNgayLamViec()+","+
                this.getSoNgayLamViec();
    }
}
