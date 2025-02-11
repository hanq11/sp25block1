package com.example.sd19308sof3022.phongKham.repository;

import com.example.sd19308sof3022.phongKham.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
}
