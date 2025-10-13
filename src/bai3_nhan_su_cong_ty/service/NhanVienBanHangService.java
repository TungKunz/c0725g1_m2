package bai3_nhan_su_cong_ty.service;

import bai3_nhan_su_cong_ty.entity.KySu;
import bai3_nhan_su_cong_ty.entity.NhanVienBanHang;
import bai3_nhan_su_cong_ty.repository.INhanVienRepository;
import bai3_nhan_su_cong_ty.repository.KySuRepository;
import bai3_nhan_su_cong_ty.repository.NhanVienBanHangRepository;

import java.util.List;

public class NhanVienBanHangService implements INhanVienService<NhanVienBanHang> {
    private static final INhanVienRepository<NhanVienBanHang> banHangRepo = new NhanVienBanHangRepository();
    @Override
    public List<NhanVienBanHang> findAll() {
        return banHangRepo.findAll();
    }

    @Override
    public boolean add(NhanVienBanHang nhanVienBanHang) {
        if(findById(nhanVienBanHang.getMaNhanVien())!=null){
            return false;
        }
        return banHangRepo.add(nhanVienBanHang);
    }

    @Override
    public boolean deleteById(NhanVienBanHang nhanVienBanHang) {
        List<NhanVienBanHang> banHangList = banHangRepo.findAll();
        boolean check= banHangList.removeIf(bh -> bh.getMaNhanVien().equals(nhanVienBanHang.getMaNhanVien()));
        if(!check){
            return false;
        }
        return ((NhanVienBanHangRepository) banHangRepo).writeAll(banHangList);
    }

    @Override
    public boolean editById(NhanVienBanHang nhanVienBanHang) {
        List<NhanVienBanHang> banHangList = banHangRepo.findAll();
        boolean check= false;
        for (int i = 0 ; i<banHangList.size();i++){
            if(banHangList.get(i).getMaNhanVien().equals(nhanVienBanHang.getMaNhanVien())){
                banHangList.set(i,nhanVienBanHang);
                check= true;
                break;
            }
        }
        if(!check){
            return false;
        }
        return ((NhanVienBanHangRepository) banHangRepo).writeAll(banHangList);
    }

    @Override
    public NhanVienBanHang findById(String id) {
        for (NhanVienBanHang bh : banHangRepo.findAll()){
            if(bh.getMaNhanVien().equalsIgnoreCase(id)){
                return bh;
            }
        }
        return null;
    }
}
