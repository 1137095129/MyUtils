package com.testpro.testproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testpro.testproject.util.EquipentUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.testpro.testproject.dao")
public class TestprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestprojectApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public EquipentUtil equipentUtil(){
        return new EquipentUtil();
    }
}
