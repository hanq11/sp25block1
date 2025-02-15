package com.example.sd19301sof3022.phongKham.service.impl;

import com.example.sd19301sof3022.phongKham.model.Thuoc;
import com.example.sd19301sof3022.phongKham.repository.ThuocRepository;
import com.example.sd19301sof3022.phongKham.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuocServiceImpl implements ThuocService {

    @Autowired
    ThuocRepository thuocRepository;

    @Override
    public List<Thuoc> getAllThuoc() {
        return thuocRepository.findAll();
    }
}
