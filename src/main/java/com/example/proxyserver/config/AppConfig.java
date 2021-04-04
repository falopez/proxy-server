package com.example.proxyserver.config;

import com.example.proxyserver.controller.PreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

}
