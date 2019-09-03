package com.testpro.testproject.dao;

import com.testpro.testproject.domain.Token;

public interface TokenDao {

    Token selectById(int id);

    void addToken(Token token);

    void updateToken(Token token);
}
