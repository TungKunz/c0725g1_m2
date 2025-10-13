package bai3_nhan_su_cong_ty.view;

import bai3_nhan_su_cong_ty.entity.KySu;
import bai3_nhan_su_cong_ty.validate.KiemTra;

import java.util.List;
import java.util.Scanner;

public class KySuView extends NhanVienView{
    private static final Scanner scanner = new Scanner(System.in);
    public static KySu nhapThongTin(String type,KySu kySu){
        if(type.equals("add")){
            kySu.setMaNhanVien(nhapMa());
        }
        kySu.setHoTen(nhapHoTen());
        kySu.setNamSinh(nhapNamSinh());
        kySu.setSoDienThoai(nhapSoDienThoai());
        kySu.setChuyenNganh(nhapChuyenNganh());
        kySu.setBacKyThuat(nhapBacKyThuat());
        return kySu;
    }
    private static String nhapMa(){
        while (true){
            System.out.println("Nhập mã kỹ sư có định dạng: KS-XXXX");
            String ma=scanner.nextLine();
            if(KiemTra.kiemTraMa("kysu",ma)){
                return ma;
            }
            System.out.println("Nhập mã sai định dạng!!!");
        }
    }
    private static String nhapChuyenNganh(){
        System.out.println("Nhập chuyên ngành ");
        return scanner.nextLine();

    }
    private static int nhapBacKyThuat(){
        while (true){
            System.out.println("Nhập bậc kĩ thuật ");
            int bacKyThuat=Integer.parseInt(scanner.nextLine());
            if(bacKyThuat >=1 && bacKyThuat<=6){
                return bacKyThuat;
            }
            System.out.println("Bậc kĩ thuật 1->6 ");
        }
    }
    public static void inThongTin(List<KySu> kySuList){
        if(kySuList.isEmpty()){
            System.out.println("Danh sách kỹ sư trống ");
            System.out.println("---------------------------------------------------------------------------");
            return;
        }
        for (KySu k:kySuList){
            System.out.println(k);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
