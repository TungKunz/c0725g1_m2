package bai_thi.controller;

import bai_thi.entity.BenhAn;
import bai_thi.entity.BenhNhanThuong;
import bai_thi.entity.BenhNhanVip;
import bai_thi.service.BenhAnService;


import bai_thi.service.IBenhAnService;
import bai_thi.validate.CheckBenhAn;
import bai_thi.view.BenhAnView;
import bai_thi.view.BenhNhanThuongView;
import bai_thi.view.BenhNhanVipView;
import java.util.Scanner;

public class BenhAnController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IBenhAnService<BenhAn> benhAnService = new BenhAnService();
    public static void BenhAnMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1. Thêm mới bệnh án
                    2. Xóa bệnh án
                    3. Hiển thị tất cả bệnh án
                    4. Thoát""");
            System.out.println("Nhập lựa chọn");
            int choise = 0;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không hợp lệ mời bạn nhập lại");
            }
            switch (choise) {
                case 1 -> themMoiBenhAn();
                case 2 -> xoaBenhAn();
                case 3 -> hienThiBenhAn();
                default -> flag = false;
            }
        }
    }

    private static void themMoiBenhAn() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1. Thêm mới bệnh nhân thường
                    2. Thêm mới bệnh nhân vip
                    3. Thoát""");
            System.out.println("Nhập lựa chọn");
            int choise;
            try {
                choise = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            switch (choise) {
                case 1 -> {
                    System.out.println("Thêm mới bệnh nhân thường");
                    BenhNhanThuong benhNhanThuong = new BenhNhanThuong();
                    BenhNhanThuongView.nhapDuLieu(benhNhanThuong);
                    boolean check = benhAnService.add(benhNhanThuong);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 2 -> {
                    System.out.println("Thêm mới bệnh nhân vip");
                    BenhNhanVip benhNhanVip = new BenhNhanVip();
                    BenhNhanVipView.nhapDuLieu(benhNhanVip);
                    boolean check = benhAnService.add(benhNhanVip);
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
    private static void xoaBenhAn() {
        System.out.print("Nhập mã bệnh án bạn muốn xóa: ");
        String maBenhAn;
        while (true) {
            maBenhAn = scanner.nextLine();
            if (CheckBenhAn.kiemTraMa(maBenhAn)) break;
            System.out.println("Mã bệnh án bạn nhập không hợp lệ");
        }
        BenhAn benhAn= benhAnService.findById(maBenhAn);
        if(benhAn!=null){
            boolean check= benhAnService.remove(benhAn);
            if(check){
                System.out.println("Xóa thành công");
            }else {
                System.out.println("Xóa không thành công");
            }
        }else {
            System.out.println("Không tìm thấy ID");
        }
    }
    private static void hienThiBenhAn(){
        System.out.println("Danh sách bệnh án");
        BenhAnView.inThongTin(benhAnService.findAll());
    }
}