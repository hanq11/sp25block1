package com.example.sd19301sof3022.phongKham.beanConfig;

import com.example.sd19301sof3022.phongKham.model.Thuoc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Thuoc getThuoc() {
        return new Thuoc(1, "Thuoc 1", 123);
    }

}
