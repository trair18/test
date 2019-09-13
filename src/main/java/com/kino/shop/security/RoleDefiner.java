package com.kino.shop.security;

import com.kino.shop.model.Token;
import com.kino.shop.repository.TokenRepository;
import com.kino.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDefiner {

    private TokenRepository tokenRepository;
    private UserRepository userRepository;

    @Autowired
    public RoleDefiner(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    public String define(String tokenValue){
        Token token = tokenRepository.findByValue(tokenValue);
        if(token == null) {
            return null;
        }
        return userRepository.findOne(token.getUserId()).getRole();
    }
}
