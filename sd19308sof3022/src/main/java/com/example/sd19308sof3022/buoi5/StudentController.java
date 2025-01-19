package com.example.sd19308sof3022.buoi5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class StudentController {
    @GetMapping("/buoi5/student")
    public String hienThi(Model model) {
        model.addAttribute("student", new Student(1, "Nguyen Van A", "Ha Noi"));

        ArrayList<Student> danhSach = new ArrayList<>();
        danhSach.add(new Student(1, "Nguyen Van B", "Ha Noi"));
        danhSach.add(new Student(2, "Tran Van C", "Bac Ninh"));
        danhSach.add(new Student(3, "Nguyen Van D", "Bac Giang"));
        model.addAttribute("danhSach", danhSach);

        return "buoi5/hien-thi";
    }


}
