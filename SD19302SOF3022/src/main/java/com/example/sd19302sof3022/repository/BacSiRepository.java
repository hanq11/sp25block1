package com.example.sd19302sof3022.repository;

import com.example.sd19302sof3022.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
}
