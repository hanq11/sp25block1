package com.example.sd19308sof3022.springBean.controller;

import com.example.sd19308sof3022.springBean.model.PhongKhamSpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/phong-kham4")
public class PhongKham4Controller {
    @Autowired
    PhongKhamSpringBean phongKhamSpringBean;

    @GetMapping("/edit-bean")
    public void editBean() {
        phongKhamSpringBean.setId(999);
    }

    @ResponseBody
    @GetMapping("/test-bean")
    public PhongKhamSpringBean testBean() {
        return phongKhamSpringBean;
    }
}
