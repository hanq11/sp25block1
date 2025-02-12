package com.example.sd19307sof3022.controller;

import com.example.sd19307sof3022.repository.BacSiRepository;
import com.example.sd19307sof3022.repository.PhongKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bac-si")
public class BacSiController {
    @Autowired
    BacSiRepository bacSiRepository;

    @Autowired
    PhongKhamRepository phongKhamRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listBacSi", bacSiRepository.findAll());
        model.addAttribute("listPhongKham", phongKhamRepository.findAll());
        return "bacSi/hien-thi";
    }
}
