package com.example.sd19308sof3022.phongKham.controller;

import com.example.sd19308sof3022.phongKham.model.BacSi;
import com.example.sd19308sof3022.phongKham.model.PhongKham;
import com.example.sd19308sof3022.phongKham.repository.BacSiRepository;
import com.example.sd19308sof3022.phongKham.repository.PhongKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bac-si")
public class BacSiController {
    @Autowired
    BacSiRepository bacSiRepository;

    @Autowired
    PhongKhamRepository phongKhamRepository;

    @ModelAttribute("listPhongKham")
    List<PhongKham> getListPhongKham() {
        return phongKhamRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listBacSi", bacSiRepository.findAll());
        return "bacSi/hien-thi";
    }

    @PostMapping("/add")
    public String add(BacSi bacSi) {
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }
}
