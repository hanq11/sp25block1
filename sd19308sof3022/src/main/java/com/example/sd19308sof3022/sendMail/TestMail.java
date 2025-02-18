package com.example.sd19308sof3022.sendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class TestMail {
    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @GetMapping("/test")
    public void send() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("");
            message.setTo("");
            message.setSubject("Hello World");
            message.setText("HelloWorld");
            mailSender.send(message);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
