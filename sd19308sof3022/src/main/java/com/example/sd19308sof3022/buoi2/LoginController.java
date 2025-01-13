package com.example.sd19308sof3022.buoi2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/buoi2")
public class LoginController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/login")
    public String showForm() {
        return "/buoi2/hien-thi";
    }

//    @PostMapping("/login")
//    public String login(Model model) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        model.addAttribute("user", username);
//        model.addAttribute("pass", password);
//        return "/buoi2/thong-tin";
//    }

//    @PostMapping("/login")
//    public String login(Model model,
//                        @RequestParam("username") String username,
//                        @RequestParam("password") String password) {
//        model.addAttribute("user", username);
//        model.addAttribute("pass", password);
//        return "/buoi2/thong-tin";
//    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, Model model) {
        model.addAttribute("user", loginRequest.getUsername());
        model.addAttribute("pass", loginRequest.getPassword());
        return "/buoi2/thong-tin";
    }
}
