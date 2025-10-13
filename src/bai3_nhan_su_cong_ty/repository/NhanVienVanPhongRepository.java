package bai3_nhan_su_cong_ty.repository;

import Furama.util.ReadAndWriteFile;
import bai3_nhan_su_cong_ty.entity.NhanVienVanPhong;
import bai3_nhan_su_cong_ty.validate.KiemTra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienVanPhongRepository implements INhanVienRepository<NhanVienVanPhong> {
    private final String NHANVIEN_FILE = "D:\\CodeGym\\Module2\\src\\bai3_nhan_su_cong_ty\\data\\nhanvien.csv";
    @Override
    public List<NhanVienVanPhong> findAll() {
        List<NhanVienVanPhong> nhanVienVanPhongList = new ArrayList<>();
        try {
            List<String> lines= ReadAndWriteFile.readFileCSVToList(NHANVIEN_FILE);
            for (String line : lines){
                String[] array = line.split(",");
                try{
                    if(array[0].equals("vanphong") && KiemTra.kiemTraMa("vanphong",array[1])){
                        NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong(array[1],array[2],Integer.parseInt(array[3]),array[4],Float.parseFloat(array[5]),Float.parseFloat(array[6]));
                        nhanVienVanPhongList.add(nhanVienVanPhong);
                    }

                }catch (Exception e){
                    System.out.println("Loi");
                }

            }
        } catch (Exception e) {
            System.out.println("Loi doc file");
        }
        return nhanVienVanPhongList;
    }

    @Override
    public boolean add(NhanVienVanPhong nhanVienVanPhong) {
        try{
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE,List.of(nhanVienVanPhong.thongTinCSV()),true);
            return true;
        }catch (IOException e){
            System.out.println("Loi ghi file");
            return false;
        }
    }
    public boolean writeAll(List<NhanVienVanPhong> nhanVienVanPhong) {
        try {
            List<String> lines = new ArrayList<>();
            for (NhanVienVanPhong b : nhanVienVanPhong) lines.add(b.thongTinCSV());
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
