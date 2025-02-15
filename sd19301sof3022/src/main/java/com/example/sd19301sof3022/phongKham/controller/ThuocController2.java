package com.example.sd19301sof3022.phongKham.controller;

import com.example.sd19301sof3022.phongKham.model.Thuoc;
import com.example.sd19301sof3022.phongKham.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/thuoc2")
public class ThuocController2 {
    @Autowired
    ThuocService thuocService;

    @Autowired
    Thuoc thuoc;

    @ResponseBody
    @GetMapping("/demo-bean")
    public Thuoc getThuoc() {
        return thuoc;
    }

    @GetMapping("/edit-bean")
    public void editThuoc() {
        thuoc.setId(9999);
    }
}
