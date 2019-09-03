package com.wjf.mytest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JSONTest {

    public String getJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<>();
        map.put("msg","测试");
        map.put("code",200);
        return objectMapper.writeValueAsString(map);
    }

}
