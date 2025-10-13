package bai3_nhan_su_cong_ty.view;

import bai3_nhan_su_cong_ty.entity.KySu;
import bai3_nhan_su_cong_ty.entity.NhanVienVanPhong;

import java.util.List;
import java.util.Scanner;

public class VanPhongView extends NhanVienView{
    private static final Scanner scanner = new Scanner(System.in);
    public static NhanVienVanPhong nhapThongTin(String type, NhanVienVanPhong nhanVienVanPhong){
        if(type.equals("add")){
            nhanVienVanPhong.setMaNhanVien(nhapMa());
        }
        nhanVienVanPhong.setHoTen(nhapHoTen());
        nhanVienVanPhong.setNamSinh(nhapNamSinh());
        nhanVienVanPhong.setSoDienThoai(nhapSoDienThoai());
        nhanVienVanPhong.setSoNgayLamViec(nhapSoNgayLamViec());
        nhanVienVanPhong.setHeSoLuong(nhapHeSoLuong());
        return nhanVienVanPhong;
    }
    private static float nhapSoNgayLamViec(){
        while (true){
            System.out.println("Nhập số ngày làm việc ");
            float soNgay=Float.parseFloat(scanner.nextLine());
            if(soNgay >0){
                return soNgay;
            }
            System.out.println("số ngày làm việc phải > 0 ");
        }

    }
    private static float nhapHeSoLuong(){
        while (true){
            System.out.println("Nhập hệ số lương ");
            float heSoLuong=Float.parseFloat(scanner.nextLine());
            if(heSoLuong >0){
                return heSoLuong;
            }
            System.out.println("hệ số lương phải > 0 ");
        }
    }
    public static void inThongTin(List<NhanVienVanPhong> nhanVienVanPhongList){
        if(nhanVienVanPhongList.isEmpty()){
            System.out.println("Danh sách văn phòng trống ");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (NhanVienVanPhong vp:nhanVienVanPhongList){
            System.out.println(vp);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
