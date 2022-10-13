package com.oct2022.oct2022.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SpringCommonConfig implements WebMvcConfigurer {
    @Autowired
    TokenInterceptor token;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }
    @Override
    public void addInterceptors(InterceptorRegistry interceptorregistry) {
        interceptorregistry.addInterceptor(token);
    }
}