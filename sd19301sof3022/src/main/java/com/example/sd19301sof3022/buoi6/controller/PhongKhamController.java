package com.example.sd19301sof3022.buoi6.controller;

import com.example.sd19301sof3022.buoi6.model.PhongKham;
import com.example.sd19301sof3022.buoi6.service.PhongKhamService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/buoi6")
public class PhongKhamController {
    @Autowired
    PhongKhamService phongKhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", phongKhamService.getAll());
        return "/buoi6/hien-thi";
    }

    @PostMapping("/add")
    public String addPhongKham(PhongKham phongKham) {
        phongKhamService.addPhongKham(phongKham);
        return "redirect:/buoi6/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("phongKham", phongKhamService.getDetail(id));
        return "/buoi6/detail";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("phongKham", phongKhamService.getDetail(id));
        return "/buoi6/update";
    }

    @PostMapping("/update")
    public String updatePhongKham(PhongKham phongKham) {
        phongKhamService.updatePhongKham(phongKham);
        return "redirect:/buoi6/hien-thi";
    }

    @GetMapping("/delete")
    public String deletePhongKham(@RequestParam("id") Integer id) {
        phongKhamService.deletePhongKham(id);
        return "redirect:/buoi6/hien-thi";
    }
}
