package bai_thi.repository;

import Furama.util.ReadAndWriteFile;
import bai_thi.entity.BenhAn;
import bai_thi.entity.BenhNhanThuong;
import bai_thi.entity.BenhNhanVip;
import bai_thi.validate.CheckBenhAn;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository<BenhAn> {
    private final String BENH_AN_FILE = "D:\\CodeGym\\Module2\\src\\bai_thi\\data\\medical_records.csv";

    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(BENH_AN_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equals("thuong") && CheckBenhAn.kiemTraMa(array[2])) {
                        BenhNhanThuong benhNhanThuong = new BenhNhanThuong(Integer.parseInt(array[1]), array[2], array[3], LocalDate.parse(array[4]), LocalDate.parse(array[5]), array[6], Double.parseDouble(array[7]));
                        benhAnList.add(benhNhanThuong);
                    }else if(array[0].equals("vip") && CheckBenhAn.kiemTraMa(array[2])){
                        BenhNhanVip benhNhanVip = new BenhNhanVip(Integer.parseInt(array[1]), array[2], array[3], LocalDate.parse(array[4]),LocalDate.parse(array[5]),array[6],array[7],LocalDate.parse(array[8]));
                        benhAnList.add(benhNhanVip);
                    }
                } catch (Exception e) {
                    System.out.println("lỗi");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return benhAnList;
    }

    @Override
    public boolean add(BenhAn benhAn) {
        try {
            ReadAndWriteFile.writeListStringToCSV(BENH_AN_FILE,
                    List.of(benhAn.thongTinCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<BenhAn> benhAnList) {
        try {
            List<String> lines = new ArrayList<>();
            for (BenhAn bn : benhAnList) lines.add(bn.thongTinCSV());
            ReadAndWriteFile.writeListStringToCSV(BENH_AN_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
