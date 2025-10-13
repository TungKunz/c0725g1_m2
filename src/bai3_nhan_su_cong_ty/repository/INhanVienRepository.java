package bai3_nhan_su_cong_ty.repository;

import java.util.List;

public interface INhanVienRepository<T>{
    List<T> findAll();
    boolean add (T t);
}
