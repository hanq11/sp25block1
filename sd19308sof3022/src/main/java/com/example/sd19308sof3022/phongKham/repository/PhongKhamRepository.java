package com.example.sd19308sof3022.phongKham.repository;

import com.example.sd19308sof3022.phongKham.model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongKhamRepository extends JpaRepository<PhongKham, Integer> {
}
