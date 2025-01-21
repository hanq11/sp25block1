package com.example.sd19308sof3022.buoi6.controller;

import com.example.sd19308sof3022.buoi6.model.PhongKham;
import com.example.sd19308sof3022.buoi6.service.PhongKhamService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phong-kham")
public class PhongKhamController {
    @Autowired
    PhongKhamService phongKhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", phongKhamService.getAll());
        return "/buoi6/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("phongKham", phongKhamService.getDetail(id));
        return "/buoi6/detail";
    }

    @GetMapping("/delete")
    public String deletePhongKham(@RequestParam("id") Integer id) {
        phongKhamService.deletePhongKham(id);
        return "redirect:/phong-kham/hien-thi";
    }

    @PostMapping("/add")
    public String themPhongKham(PhongKham phongKham) {
        phongKhamService.addPhongKham(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String showUpate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("phongKham", phongKhamService.getDetail(id));
        return "/buoi6/view-update";
    }

    @PostMapping("/update")
    public String updatePHongKham(PhongKham phongKham) {
        phongKhamService.updatePhongKham(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }
}
