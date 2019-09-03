package com.testpro.testproject.service.impl;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testpro.testproject.domain.Token;
import com.testpro.testproject.dao.TokenDao;
import com.testpro.testproject.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Token selectById(int id) {
        Token token = tokenDao.selectById(id);

        if (token.getToken()==null||"".equals(token.getToken())){
            token = this.getToken(token.getId(), "39359cd15dfa45539b28e3b6b018687a", "73c526f4ef9f9b2cf06e68090b00e7d4");
        }else if(token.getTime().before(new Date())){
            token = this.getToken(token.getId(), "39359cd15dfa45539b28e3b6b018687a", "73c526f4ef9f9b2cf06e68090b00e7d4");
        }

        System.out.println(token.getToken());

        return token;
    }

    @Override
    public void addToken(Token token) {
        tokenDao.addToken(token);
    }

    @Override
    public void updateToken(Token token) {
        tokenDao.updateToken(token);
    }

    private Token getToken(int id, String appKey, String appSecret){

        Token token = new Token();
        token.setId(id);

        Map<String,Object> map = new HashMap<>();
        map.put("appKey",appKey);
        map.put("appSecret",appSecret);
        String post = HttpUtil.post("https://open.ys7.com/api/lapp/token/get", map);
        System.out.println(post);
        Map map1 = null;
        try {
            map1 = objectMapper.readValue(post, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map1);

        if(Integer.parseInt((String) map1.get("code"))==200){
            token.setTime(new Date((Long) ((Map)map1.get("data")).get("expireTime")));
            token.setToken((String) ((Map)map1.get("data")).get("accessToken"));
            tokenDao.updateToken(token);
        }else {
            token.setToken("请求错误！");
        }
        return token;
    }
}
