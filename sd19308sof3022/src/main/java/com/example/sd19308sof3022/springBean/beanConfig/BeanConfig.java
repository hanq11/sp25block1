package com.example.sd19308sof3022.springBean.beanConfig;

import com.example.sd19308sof3022.springBean.model.PhongKhamSpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PhongKhamSpringBean getPhongKhamBean() {
        return new PhongKhamSpringBean(1, "Phong kham 1", "Dia chi");
    }
}
