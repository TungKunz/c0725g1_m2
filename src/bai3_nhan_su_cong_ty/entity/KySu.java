package bai3_nhan_su_cong_ty.entity;

public class KySu extends NhanVien{
    private String chuyenNganh;
    private int bacKyThuat;

    public KySu() {

    }

    public KySu(String maNhanVien, String hoTen, int namSinh, String soDienThoai, String chuyenNganh, int bacKyThuat) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.chuyenNganh = chuyenNganh;
        this.bacKyThuat = bacKyThuat;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getBacKyThuat() {
        return bacKyThuat;
    }

    public void setBacKyThuat(int bacKyThuat) {
        this.bacKyThuat = bacKyThuat;
    }


    @Override
    public String toString() {
        return "KySu {" +super.toString()+
                " chuyenNganh = " + chuyenNganh +
                ", bacKyThuat = " + bacKyThuat +
                '}';
    }

    @Override
    public String thongTinCSV() {
        return "kysu" +","+
                super.getMaNhanVien()+","+
                super.getHoTen()+","+
                super.getNamSinh()+","+
                super.getSoDienThoai()+","+
                this.getChuyenNganh()+","+
                this.getBacKyThuat();
    }
}
