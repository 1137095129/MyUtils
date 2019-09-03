package com.wjf.mytest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@SpringBootApplication
public class JSONTestTest {

    @Test
    public void getJson() throws JsonProcessingException {
        System.out.println(new JSONTest().getJson());
        System.out.println("{\"msg\":\"测试\",\"code\":200}");
    }
}