package com.example.sd19308sof3022.phongKham.controller;

import com.example.sd19308sof3022.phongKham.model.BacSi;
import com.example.sd19308sof3022.phongKham.model.PhongKham;
import com.example.sd19308sof3022.phongKham.repository.BacSiRepository;
import com.example.sd19308sof3022.phongKham.repository.PhongKhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public String hienThi(Model model, @ModelAttribute BacSi bacSi) {
        model.addAttribute("listBacSi", bacSiRepository.findAll());
        bacSiRepository.timKiemTheoKhoangLuongNative(10, 300).forEach(bs -> System.out.println(bs.getTen()));
        bacSiRepository.timKiemTheoKhoangLuong(10, 300).forEach(bs -> System.out.println(bs.getTen()));
        return "bacSi/hien-thi";
    }

    @GetMapping("/tim-kiem-theo-ten")
    public String timKiem(Model model, @RequestParam("ten") String ten, BacSi bacSi) {
        model.addAttribute("listBacSi", bacSiRepository.findBacSisByTenContainsOrderByLuongDesc(ten));
        return "bacSi/hien-thi";
    }
    @GetMapping("/phan-trang")
    public String phanTrang(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page
                            , Model model) {
        int size = 3;
        Sort sort = Sort.by(Sort.Direction.DESC, "ten");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("page", bacSiRepository.findAll(pageable));
        return "bacSi/phan-trang";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid BacSi bacSi, Errors errors) {
        if(errors.hasErrors()) {
            model.addAttribute("listBacSi", bacSiRepository.findAll());
            return "bacSi/hien-thi";
        }
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bacSi", bacSiRepository.findById(id).get());
        return "bacSi/view-update";
    }

    @PostMapping("/update")
    public String update(BacSi bacSi) {
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        bacSiRepository.deleteById(id);
        return "redirect:/bac-si/hien-thi";
    }
}
