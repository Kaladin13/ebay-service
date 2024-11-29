package com.example.ebay_service.filter;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
                .allowedOrigins("*") 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD") 
                .allowedHeaders("X-Requested-With", "Authorization", "Accept-Version", "Content-MD5", "CSRF-Token", "Content-Type") 
                .allowCredentials(true); 
    }
}

