package bai3_nhan_su_cong_ty.entity;

public class NhanVienBanHang extends NhanVien{
    private int doanhSo;
    private float hoaHong;

    public NhanVienBanHang() {
    }

    public NhanVienBanHang(String maNhanVien, String hoTen, int namSinh, String soDienThoai, int doanhSo, float hoaHong) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public int getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(int doanhSo) {
        this.doanhSo = doanhSo;
    }

    public float getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(float hoaHong) {
        this.hoaHong = hoaHong;
    }

    @Override
    public String toString() {
        return "NhanVienBanHang {" +super.toString()+
                " doanhSo = " + doanhSo +
                ", hoaHong = " + hoaHong +
                '}';
    }

    @Override
    public String thongTinCSV() {
        return "banhang" +","+
                super.getMaNhanVien()+","+
                super.getHoTen()+","+
                super.getNamSinh()+","+
                super.getSoDienThoai()+","+
                this.getDoanhSo()+","+
                this.getHoaHong();
    }
}
