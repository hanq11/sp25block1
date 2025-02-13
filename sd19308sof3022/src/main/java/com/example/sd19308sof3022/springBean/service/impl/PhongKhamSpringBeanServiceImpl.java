package com.example.sd19308sof3022.springBean.service.impl;

import com.example.sd19308sof3022.springBean.model.PhongKhamSpringBean;
import com.example.sd19308sof3022.springBean.repository.PhongKhamSpringBeanRepository;
import com.example.sd19308sof3022.springBean.service.PhongKhamSpringBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongKhamSpringBeanServiceImpl implements PhongKhamSpringBeanService {
    @Autowired
    PhongKhamSpringBeanRepository phongKhamSpringBeanRepository;

    @Override
    public List<PhongKhamSpringBean> getListPhongKham() {
        return phongKhamSpringBeanRepository.findAll();
    }
}
