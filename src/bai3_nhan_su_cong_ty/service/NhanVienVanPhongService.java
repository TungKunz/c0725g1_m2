package bai3_nhan_su_cong_ty.service;

import bai3_nhan_su_cong_ty.entity.NhanVienVanPhong;
import bai3_nhan_su_cong_ty.repository.INhanVienRepository;
import bai3_nhan_su_cong_ty.repository.NhanVienVanPhongRepository;

import java.util.List;

public class NhanVienVanPhongService implements INhanVienService<NhanVienVanPhong>{
    private static final INhanVienRepository<NhanVienVanPhong> vanPhongRepo = new NhanVienVanPhongRepository();

    @Override
    public List<NhanVienVanPhong> findAll() {
        return vanPhongRepo.findAll();
    }

    @Override
    public boolean add(NhanVienVanPhong nhanVienVanPhong) {
        if(findById(nhanVienVanPhong.getMaNhanVien())!=null){
            return false;
        }
        return vanPhongRepo.add(nhanVienVanPhong);
    }

    @Override
    public boolean deleteById(NhanVienVanPhong nhanVienVanPhong) {
        List<NhanVienVanPhong> nhanVienVanPhongList = vanPhongRepo.findAll();
        boolean check = nhanVienVanPhongList.removeIf(vp-> vp.getMaNhanVien().equals(nhanVienVanPhong.getMaNhanVien()));
        if(!check){
            return false;
        }
        return ((NhanVienVanPhongRepository) vanPhongRepo).writeAll(nhanVienVanPhongList);
    }

    @Override
    public boolean editById(NhanVienVanPhong nhanVienVanPhong) {
        List<NhanVienVanPhong> nhanVienVanPhongList= vanPhongRepo.findAll();
        boolean check = false;
        for (int i = 0; i < nhanVienVanPhongList.size(); i++) {
            if(nhanVienVanPhongList.get(i).getMaNhanVien().equals(nhanVienVanPhong.getMaNhanVien())){
                nhanVienVanPhongList.set(i,nhanVienVanPhong);
                check=true;
            }
        }
        if(!check){
            return false;
        }
        return ((NhanVienVanPhongRepository) vanPhongRepo).writeAll(nhanVienVanPhongList);
    }

    @Override
    public NhanVienVanPhong findById(String id) {
        List<NhanVienVanPhong> nhanVienVanPhongList=vanPhongRepo.findAll();
        for (NhanVienVanPhong vp : nhanVienVanPhongList){
            if(vp.getMaNhanVien().equals(id)){
                return vp;
            }
        }
        return null;
    }
}
