package com.myopttest.opttest;

import com.myopttest.opttest.untils.ExcelUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.myopttest.opttest.dao")
public class OpttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpttestApplication.class, args);
    }

    @Bean
    public ExcelUtil excelUtil(){
        return new ExcelUtil();
    }
}
