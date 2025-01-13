package com.example.sd19308sof3022.buoi1;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld(Model model) {
        System.out.println("da duoc chay");
        model.addAttribute("ten", "SD1930");
        return "buoi1/helloWorld";
    }
}
