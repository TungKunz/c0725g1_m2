package bai3_nhan_su_cong_ty.service;

import bai3_nhan_su_cong_ty.entity.KySu;
import bai3_nhan_su_cong_ty.repository.INhanVienRepository;
import bai3_nhan_su_cong_ty.repository.KySuRepository;

import java.util.List;

public class KySuService implements INhanVienService<KySu> {
    private static final INhanVienRepository<KySu> kySuRepo = new KySuRepository();

    @Override
    public List<KySu> findAll() {
        return kySuRepo.findAll();
    }

    @Override
    public boolean add(KySu kySu) {
        if(findById(kySu.getMaNhanVien())!=null){
            return false;
        }
        return kySuRepo.add(kySu);
    }

    @Override
    public boolean deleteById(KySu kySu) {
        List<KySu> kySuList = kySuRepo.findAll();
        boolean removed = kySuList.removeIf(k->k.getMaNhanVien().equals(kySu.getMaNhanVien()));
        if(!removed){
            return false;
        }
        return ((KySuRepository) kySuRepo).writeAll(kySuList);

    }

    @Override
    public boolean editById(KySu kySu) {
        List<KySu> kySuList = kySuRepo.findAll();
        boolean check= false;
        for (int i = 0 ; i<kySuList.size();i++){
            if(kySuList.get(i).getMaNhanVien().equals(kySu.getMaNhanVien())){
                kySuList.set(i,kySu);
                check= true;
                break;
            }
        }
        if(!check){
            return false;
        }
        return ((KySuRepository) kySuRepo).writeAll(kySuList);
    }

    @Override
    public KySu findById(String id) {
        for (KySu k : kySuRepo.findAll()){
            if(k.getMaNhanVien().equalsIgnoreCase(id)){
                return k;
            }
        }
        return null;
    }
}
