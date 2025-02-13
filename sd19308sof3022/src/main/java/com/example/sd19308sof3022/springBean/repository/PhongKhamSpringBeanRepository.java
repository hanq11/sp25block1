package com.example.sd19308sof3022.springBean.repository;

import com.example.sd19308sof3022.springBean.model.PhongKhamSpringBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongKhamSpringBeanRepository extends JpaRepository<PhongKhamSpringBean, Integer> {
}
