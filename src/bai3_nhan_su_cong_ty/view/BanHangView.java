package bai3_nhan_su_cong_ty.view;

import bai3_nhan_su_cong_ty.entity.NhanVienBanHang;

import java.util.List;
import java.util.Scanner;

public class BanHangView extends NhanVienView{
    private static final Scanner scanner = new Scanner(System.in);
    public static NhanVienBanHang nhapThongTin(String type, NhanVienBanHang nhanVienBanHang){
        if(type.equals("add")){
            nhanVienBanHang.setMaNhanVien(nhapMa());
        }
        nhanVienBanHang.setHoTen(nhapHoTen());
        nhanVienBanHang.setNamSinh(nhapNamSinh());
        nhanVienBanHang.setSoDienThoai(nhapSoDienThoai());
        nhanVienBanHang.setDoanhSo(nhapDoanhSo());
        nhanVienBanHang.setHoaHong(nhapHoaHong());
        return nhanVienBanHang;
    }
    private static int nhapDoanhSo(){
        while (true){
            System.out.println("Nhập doanh số");
            int doanhSo=Integer.parseInt(scanner.nextLine());
            if(doanhSo>0){
                return doanhSo;
            }
            System.out.println("Doanh số phải > 0 ");
        }
    }
    private static float nhapHoaHong(){
        while (true){
            System.out.println("Nhập hoa hồng ");
            float hoaHong=Float.parseFloat(scanner.nextLine());
            if(hoaHong >0){
                return hoaHong;
            }
            System.out.println("Hoa hồng phải > 0");
        }
    }
    public  static void inThongTin(List<NhanVienBanHang> nhanVienBanHangList){
        if(nhanVienBanHangList.isEmpty()){
            System.out.println("Danh sách nhân viên bán hàng trống");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (NhanVienBanHang bh : nhanVienBanHangList){
            System.out.println(bh);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
