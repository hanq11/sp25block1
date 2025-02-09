package com.example.sd19301sof3022.phongKham.repository;

import com.example.sd19301sof3022.phongKham.model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongKhamRepository extends JpaRepository<PhongKham, Integer> {
}
