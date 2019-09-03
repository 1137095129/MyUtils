package com.testpro.testproject.service;

import com.testpro.testproject.domain.Token;

public interface TokenService {

    Token selectById(int id);

    void addToken(Token token);

    void updateToken(Token token);
}
