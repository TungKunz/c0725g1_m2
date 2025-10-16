package bai_thi.service;

import bai_thi.entity.BenhAn;

import bai_thi.repository.BenhAnRepository;

import bai_thi.repository.IBenhAnRepository;

import java.util.List;

public class BenhAnService implements  IBenhAnService<BenhAn> {
    private static final IBenhAnRepository<BenhAn> benhAnRepo= new BenhAnRepository();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepo.findAll();
    }

    @Override
    public boolean add(BenhAn benhAn) {
        List<BenhAn> benhAnList = findAll();
        if(benhAnList.isEmpty()){
            benhAn.setStt(1);
        }else {
            BenhAn benhAnCuoi= benhAnList.get(benhAnList.size()-1);
            benhAn.setStt(benhAnCuoi.getStt()+1);
        }
        if(findById(benhAn.getMaBenhAn())!=null){
            return false;
        }
        return benhAnRepo.add(benhAn);
    }

    @Override
    public boolean remove(BenhAn benhAn) {
        List<BenhAn> benhAnList= findAll();
        boolean check=benhAnList.removeIf(bn->bn.getMaBenhAn().equals(benhAn.getMaBenhAn()));
        if(!check){
            return false;
        }else {
            return ((BenhAnRepository) benhAnRepo).writeAll(benhAnList);
        }
    }

    @Override
    public BenhAn findById(String id) {
        List<BenhAn> benhAnList= findAll();
        for (BenhAn bn: benhAnList){
            if(bn.getMaBenhAn().equals(id)){
                return bn;
            }
        }
        return null;
    }
}
