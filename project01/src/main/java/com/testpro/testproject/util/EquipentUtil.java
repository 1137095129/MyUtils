package com.testpro.testproject.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class EquipentUtil {

    @Autowired
    private ObjectMapper objectMapper;

    public Map<String,Object> util(String post){
        System.out.println(post);
        Map value = null;
        try {
            value = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
