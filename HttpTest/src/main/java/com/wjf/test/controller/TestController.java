package com.wjf.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/controller")
@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/getTest")
    public Map<String,Object> getTest(String msg, String code){

        System.out.println(msg+"---------------"+code);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","欢迎使用get访问");
        map.put("code",204);

        return map;

    }

    @ResponseBody
    @PostMapping("/postTest")
    public Map<String,Object> postTest(@RequestBody String map) {

        System.out.println(map);
        /*request.setCharacterEncoding("utf-8");

        String msg = "";
        StringBuffer sb = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        String temp = "";

        while ((temp=reader.readLine())!=null){
            sb.append(temp);
            sb.append("\n");
        }*//*

        msg = sb.toString();
        System.out.println(msg);*/

        Map<String,Object> result = new HashMap<>();
        result.put("msg","欢迎使用post访问");
        result.put("code",204);

        return result;
    }

}
