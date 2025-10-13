package bai3_nhan_su_cong_ty.repository;

import Furama.util.ReadAndWriteFile;
import bai3_nhan_su_cong_ty.entity.NhanVienBanHang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienBanHangRepository implements INhanVienRepository<NhanVienBanHang> {
    private final String NHANVIEN_FILE = "D:\\CodeGym\\Module2\\src\\bai3_nhan_su_cong_ty\\data\\nhanvien.csv";
    @Override
    public List<NhanVienBanHang> findAll() {
        List<NhanVienBanHang> nhanVienBanHangList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(NHANVIEN_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equals("banhang")) {
                        NhanVienBanHang nhanVienBanHang = new NhanVienBanHang(array[1], array[2], Integer.parseInt(array[3]), array[4],
                                Integer.parseInt(array[5]), Float.parseFloat(array[6]));
                        nhanVienBanHangList.add(nhanVienBanHang);
                    }
                }catch (Exception e){
                    System.out.println("lỗi");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return nhanVienBanHangList;
    }

    @Override
    public boolean add(NhanVienBanHang nhanVienBanHang) {
        try {
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE,
                    List.of(nhanVienBanHang.thongTinCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<NhanVienBanHang> nhanVienBanHang) {
        try {
            List<String> lines = new ArrayList<>();
            for (NhanVienBanHang b : nhanVienBanHang) lines.add(b.thongTinCSV());
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
