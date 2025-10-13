package bai3_nhan_su_cong_ty.controller;

import bai3_nhan_su_cong_ty.entity.KySu;
import bai3_nhan_su_cong_ty.entity.NhanVien;
import bai3_nhan_su_cong_ty.entity.NhanVienBanHang;
import bai3_nhan_su_cong_ty.entity.NhanVienVanPhong;
import bai3_nhan_su_cong_ty.service.INhanVienService;
import bai3_nhan_su_cong_ty.service.KySuService;
import bai3_nhan_su_cong_ty.service.NhanVienBanHangService;
import bai3_nhan_su_cong_ty.service.NhanVienVanPhongService;
import bai3_nhan_su_cong_ty.validate.KiemTra;
import bai3_nhan_su_cong_ty.view.BanHangView;
import bai3_nhan_su_cong_ty.view.KySuView;
import bai3_nhan_su_cong_ty.view.VanPhongView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienController {
    private static final INhanVienService<KySu> kySuService = new KySuService();
    private static final INhanVienService<NhanVienVanPhong> vanPhongService = new NhanVienVanPhongService();
    private static final INhanVienService<NhanVienBanHang> banHangService = new NhanVienBanHangService();

    private static final Scanner scanner = new Scanner(System.in);

    public static void NhanVienManager() {
        while (true) {
            System.out.println("""
                    1. Thêm nhân sự
                    2. Hiển thị danh sách nhân sự theo loại
                    3. Sửa thông tin nhân sự theo mã nhân viên
                    4. Xóa nhân sự theo mã nhân viên
                    5. Tìm kiếm theo tên(gần đúng)
                    6. Thoát
                    """);
            System.out.println("Nhập lựa chọn: ");
            int choise;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập lựa chọn không đúng, mời nhập lại");
                continue;
            }
            switch (choise) {
                case 1 -> themMoiNhanVien();
                case 2 -> hienThiDanhSach();
                case 3 -> suaThongTinNhanVien();
                case 4 -> xoaThongTinNhanVien();
                case 5 -> timKiem();
                case 6 -> {
                    System.out.println("Thoát chương trình");
                    return;
                }
                default -> System.out.println("Mời bạn nhập lại");
            }
        }
    }

    private static void themMoiNhanVien() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1. Thêm mới Kỹ Sư
                    2. Thêm mới nhân viên văn phòng
                    3. Thêm mới nhân viên bán hàng
                    4. Thoát
                    """);
            System.out.println("Nhập lựa chọn: ");
            int choise;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không đúng mời bạn nhập lại");
                continue;
            }
            switch (choise) {
                case 1 -> {
                    System.out.println("Thêm mới kỹ sư");
                    KySu kySu = new KySu();
                    KySuView.nhapThongTin("add", kySu);
                    boolean check = kySuService.add(kySu);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 2 -> {
                    System.out.println("Thêm mới nhân viên văn phòng");
                    NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong();
                    VanPhongView.nhapThongTin("add", nhanVienVanPhong);
                    boolean check = vanPhongService.add(nhanVienVanPhong);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 3 -> {
                    System.out.println("Thêm mới nhân viên bán hàng");
                    NhanVienBanHang nhanVienBanHang = new NhanVienBanHang();
                    BanHangView.nhapThongTin("add", nhanVienBanHang);
                    boolean check = banHangService.add(nhanVienBanHang);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                default -> flag = false;
            }
        }
    }

    private static void hienThiDanhSach() {
        System.out.println("Danh sách nhân viên");
        KySuView.inThongTin(kySuService.findAll());
        VanPhongView.inThongTin(vanPhongService.findAll());
        BanHangView.inThongTin(banHangService.findAll());
    }

    private static void suaThongTinNhanVien() {
        System.out.println("Nhập mã nhân viên bạn muốn sửa");
        String maNhanVien = scanner.nextLine();
        KySu kySu = kySuService.findById(maNhanVien);
        NhanVienVanPhong nhanVienVanPhong = vanPhongService.findById(maNhanVien);
        NhanVienBanHang nhanVienBanHang = banHangService.findById(maNhanVien);
        if (kySu != null) {
            KySuView.nhapThongTin("edit", kySu);
            boolean check = kySuService.editById(kySu);
            if (check) {

                System.out.println("Sửa thông tin kỹ sư thành công");
            } else {
                System.out.println("Sửa thông tin kỹ sư không thành công");
            }
        } else if (nhanVienVanPhong != null) {
            VanPhongView.nhapThongTin("edit", nhanVienVanPhong);
            boolean check = vanPhongService.editById(nhanVienVanPhong);
            if (check) {
                System.out.println("Sửa thông tin nhân viên văn phòng thành công");
            } else {
                System.out.println("Sửa thông tin nhân viên văn phòng không thành công");
            }
        } else if (nhanVienBanHang != null) {
            BanHangView.nhapThongTin("edit", nhanVienBanHang);
            boolean check = banHangService.editById(nhanVienBanHang);
            if (check) {
                System.out.println("Sửa thông tin nhân viên bán hàng thành công");
            } else {
                System.out.println("Sửa thông tin nhân viên bán hàng không thành công");
            }
        } else {
            System.out.println("Không tìm thấy mã nhân viên");
        }
    }

    private static void xoaThongTinNhanVien() {
        System.out.print("Nhập mã nhân viên bạn muốn xóa: ");
        String maNhanVien = scanner.nextLine();
        boolean check = KiemTra.kiemTraMa("kysu",maNhanVien);
        String type="kỹ sư";
        if(!check){
            check=KiemTra.kiemTraMa("vanphong",maNhanVien);
            type="văn phòng";
        }
        if(!check){
            check=KiemTra.kiemTraMa("banhang",maNhanVien);
            type="bán hàng";
        }
        if (check) {
            boolean result = false;

            switch (type) {
                case "kỹ sư":
                    KySu kySu = kySuService.findById(maNhanVien);
                    if (kySu != null) {
                        result = kySuService.deleteById(kySu);
                    }
                    break;

                case "văn phòng":
                    NhanVienVanPhong nhanVienVanPhong = vanPhongService.findById(maNhanVien);
                    if (nhanVienVanPhong != null) {
                        result = vanPhongService.deleteById(nhanVienVanPhong);
                    }
                    break;

                case "bán hàng":
                    NhanVienBanHang nhanVienBanHang = banHangService.findById(maNhanVien);
                    if (nhanVienBanHang != null) {
                        result = banHangService.deleteById(nhanVienBanHang);
                    }
                    break;
            }

            if (result) {
                System.out.println("Xóa thông tin nhân viên " + type + " thành công");
            } else {
                System.out.println("Xóa thông tin nhân viên " + type + " không thành công");
            }

        } else {
            System.out.println("Không tìm thấy mã nhân viên nào trùng khớp");
        }

    }

    private static void timKiem(){
        System.out.println("Nhập tên mà bạn muốn tìm kiếm");
        String ten= scanner.nextLine();
        List<NhanVien> nhanVienList = new ArrayList<>();
        List<NhanVien> listTotal = new ArrayList<>();
        nhanVienList.addAll(kySuService.findAll());
        nhanVienList.addAll(vanPhongService.findAll());
        nhanVienList.addAll(banHangService.findAll());
        for(NhanVien nhanVien : nhanVienList){
            if(nhanVien.getHoTen().toLowerCase().contains(ten.toLowerCase())){
                listTotal.add(nhanVien);
            }
        }
        if(listTotal.isEmpty()){
            System.out.println("Danh sách trống không tìm thấy tên nào!!!");
        }else {
            System.out.println("Kết quả tìm kiếm theo tên");
            for (NhanVien nhanVien : listTotal){
                System.out.println(nhanVien);
            }
        }
    }

}
