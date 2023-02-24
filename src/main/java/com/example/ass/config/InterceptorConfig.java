package com.example.ass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.ass.interceptor.AccountInterceptor;
import com.example.ass.interceptor.CartInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	AccountInterceptor accountInterceptor;
	@Autowired
	CartInterceptor cartInterceptor;
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accountInterceptor);
        registry.addInterceptor(cartInterceptor);
    }
}
