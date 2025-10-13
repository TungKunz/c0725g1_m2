package bai3_nhan_su_cong_ty.service;

import java.util.List;

public interface INhanVienService<T> {
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
    T findById(String id);
}
