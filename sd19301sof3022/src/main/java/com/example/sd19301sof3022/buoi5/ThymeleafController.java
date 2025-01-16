package com.example.sd19301sof3022.buoi5;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    @GetMapping("/buoi5/demo")
    public String demo(Model model) {
        model.addAttribute("id", 345);
        return "buoi5/demo";
    }

    @GetMapping("/buoi5/demo-bang")
    public String demoBang(Model model) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Nguyen Van A", 19));
        list.add(new Student(2, "Tran Van B", 25));
        list.add(new Student(3, "Dao Van C", 26));
        model.addAttribute("danhSach", list);
        return "buoi5/demo";
    }
}
