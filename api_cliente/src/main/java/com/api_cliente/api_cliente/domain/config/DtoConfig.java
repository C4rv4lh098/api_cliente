package com.api_cliente.api_cliente.domain.config;

import com.api_cliente.api_cliente.domain.dto.ResponseDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConfig {
    @Bean
    public ResponseDto responseDto(){
        return new ResponseDto();
    }
}
