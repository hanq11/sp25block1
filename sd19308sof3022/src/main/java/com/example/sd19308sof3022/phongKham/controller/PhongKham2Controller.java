package com.example.sd19308sof3022.phongKham.controller;

import com.example.sd19308sof3022.phongKham.model.PhongKham;
import com.example.sd19308sof3022.phongKham.repository.PhongKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phong-kham2")
public class PhongKham2Controller {
    @Autowired
    PhongKhamRepository phongKhamRepository;

    //        phongKhamRepository.findById();
    //        phongKhamRepository.deleteById();
    //        phongKhamRepository.save(); // update - create
    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", phongKhamRepository.findAll());
        return "phongKham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("phongKham", phongKhamRepository.findById(id).get());
        return "phongKham/detail";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("phongKham", phongKhamRepository.findById(id).get());
        return "phongKham/view-update";
    }

    @PostMapping("/update")
    public String update(PhongKham phongKham) {
        phongKhamRepository.save(phongKham);
        return "redirect:/phong-kham2/hien-thi";
    }

    @PostMapping("/add")
    public String add(PhongKham phongKham) {
        phongKhamRepository.save(phongKham);
        return "redirect:/phong-kham2/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        phongKhamRepository.deleteById(id);
        return "redirect:/phong-kham2/hien-thi";
    }
}
