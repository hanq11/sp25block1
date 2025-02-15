package com.example.sd19301sof3022.phongKham.controller;

import com.example.sd19301sof3022.phongKham.model.Thuoc;
import com.example.sd19301sof3022.phongKham.repository.ThuocRepository;
import com.example.sd19301sof3022.phongKham.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/thuoc")
public class ThuocController {
    @Autowired
    ThuocService thuocService;

    @Autowired
    ThuocRepository thuocRepository;

    @Autowired
    Thuoc thuoc;

    @ResponseBody
    @GetMapping("/hien-thi")
    public List<Thuoc> hienThi() {
        return thuocService.getAllThuoc();
    }

    @ResponseBody
    @GetMapping("/demo-bean")
    public Thuoc getThuoc() {
        return thuoc;
    }

    @ResponseBody
    @GetMapping("/test-query-method-jpa")
    public List<Thuoc> getListThuocJPA(@RequestParam("ten") String ten, @RequestParam("gia") Integer gia) {
        return thuocRepository.findThuocByTenContainsAndAndGiaGreaterThanOrderByIdDesc(ten, gia);
    }
}
