package com.testpro.testproject.controller;


import com.testpro.testproject.domain.Token;
import com.testpro.testproject.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/token")
@ResponseBody
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/selectById/{id}")
    public Token selectById(@PathVariable("id") int id){
        return tokenService.selectById(id);
    }

    @PutMapping("/updateToken")
    public void updateToken(Token token) {
        tokenService.updateToken(token);
    }
}
