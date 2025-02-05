package com.example.employee.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // This will create and return a ModelMapper instance
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
