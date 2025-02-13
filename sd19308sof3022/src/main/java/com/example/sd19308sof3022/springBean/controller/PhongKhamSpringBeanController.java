package com.example.sd19308sof3022.springBean.controller;

import com.example.sd19308sof3022.springBean.model.PhongKhamSpringBean;
import com.example.sd19308sof3022.springBean.service.PhongKhamSpringBeanService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/phong-kham3")
public class PhongKhamSpringBeanController {
    @Autowired
    PhongKhamSpringBeanService phongKhamSpringBeanService;

    @Autowired
    PhongKhamSpringBean phongKhamSpringBean;

    @ResponseBody
    @GetMapping("/hien-thi")
    public List<PhongKhamSpringBean> hienThi() {
        return phongKhamSpringBeanService.getListPhongKham();
    }

    @ResponseBody
    @GetMapping("/test-bean")
    public PhongKhamSpringBean testBean() {
        return phongKhamSpringBean;
    }
}
