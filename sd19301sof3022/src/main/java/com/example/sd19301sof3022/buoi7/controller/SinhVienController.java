package com.example.sd19301sof3022.buoi7.controller;

import com.example.sd19301sof3022.buoi7.model.SinhVien;
import com.example.sd19301sof3022.buoi7.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", sinhVienService.getAll());
        return "buoi7/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sinhVien", sinhVienService.getOne(id));
        return "buoi7/detail";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sinhVien", sinhVienService.getOne(id));
        return "buoi7/view-update";
    }

    @PostMapping("/update")
    public String update(SinhVien sinhVien) {
        sinhVienService.update(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

    @PostMapping("/add")
    public String add(SinhVien sinhVien) {
        sinhVienService.add(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        sinhVienService.delete(id);
        return "redirect:/sinh-vien/hien-thi";
    }
}
