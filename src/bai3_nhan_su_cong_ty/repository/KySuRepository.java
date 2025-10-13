package bai3_nhan_su_cong_ty.repository;

import Furama.util.ReadAndWriteFile;
import bai3_nhan_su_cong_ty.entity.KySu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KySuRepository implements INhanVienRepository<KySu> {
    private final String NHANVIEN_FILE = "D:\\CodeGym\\Module2\\src\\bai3_nhan_su_cong_ty\\data\\nhanvien.csv";
    @Override
    public List<KySu> findAll() {
        List<KySu> kySuList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(NHANVIEN_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equalsIgnoreCase("kysu")) {
                        KySu kySu = new KySu(array[1], array[2], Integer.parseInt(array[3]), array[4],
                                array[5], Integer.parseInt(array[6]));
                        kySuList.add(kySu);
                    }
                }catch (Exception e){
                    System.out.println("lỗi");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return kySuList;
    }

    @Override
    public boolean add(KySu kySu) {
        try {
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE,
                    List.of(kySu.thongTinCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<KySu> kySu) {
        try {
            List<String> lines = new ArrayList<>();
            for (KySu b : kySu) lines.add(b.thongTinCSV());
            ReadAndWriteFile.writeListStringToCSV(NHANVIEN_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
