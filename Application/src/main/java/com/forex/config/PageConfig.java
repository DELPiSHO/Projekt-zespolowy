package com.forex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class PageConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/dashboard2").setViewName("dashboard2");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/user-home").setViewName("user-home");
        registry.addViewController("/user-info").setViewName("user-info");
        registry.addViewController("/user-edit").setViewName("user-edit");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/data").setViewName("data");
        registry.addViewController("/currencypick").setViewName("currencypick");
    }

}
