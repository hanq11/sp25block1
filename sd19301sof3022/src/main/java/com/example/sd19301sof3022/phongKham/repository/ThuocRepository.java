package com.example.sd19301sof3022.phongKham.repository;

import com.example.sd19301sof3022.phongKham.model.Thuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuocRepository extends JpaRepository<Thuoc, Integer> {
    public List<Thuoc> findThuocByTenContainsAndAndGiaGreaterThanOrderByIdDesc(String ten, Integer gia);
}
