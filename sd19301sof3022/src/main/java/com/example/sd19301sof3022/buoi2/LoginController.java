package com.example.sd19301sof3022.buoi2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/buoi2")
public class LoginController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/login")
    public String hienThi() {
        return "/buoi2/login-form";
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
//                        @RequestParam(name = "username", defaultValue = "default") String username,
//                        @RequestParam(name = "password", required = false) Optional<String> password,
//                        @RequestParam(name = "remember", defaultValue = "false") boolean remember) {
//        if(password.isPresent() && password.get().contains("123")) {
//            System.out.println("Co chua 123");
//        } else {
//            System.out.println("Chua truyen len password");
//        }
//
//        model.addAttribute("user", username);
//        model.addAttribute("pass", password);
//        model.addAttribute("remember", remember);
//        return "/buoi2/thong-tin";
//    }

    @PostMapping("/login")
    public String login(Model model, LoginRequest loginRequest) {
        model.addAttribute("user", loginRequest.getUsername());
        model.addAttribute("pass", loginRequest.getPassword());
        model.addAttribute("remember", loginRequest.isRemember());
        return "/buoi2/thong-tin";
    }

    @GetMapping("/demo-path-variable/{id}")
    @ResponseBody
    public void demo(@PathVariable("id") Integer id) {
        System.out.println(id);
    }
}
