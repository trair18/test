package com.kino.shop.service;

import com.kino.shop.dto.LoginReq;
import com.kino.shop.dto.LoginRes;
import com.kino.shop.exception.UserNotFoundException;
import com.kino.shop.exception.WrongPasswordException;
import com.kino.shop.model.Token;
import com.kino.shop.model.User;
import com.kino.shop.repository.TokenRepository;
import com.kino.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    @Autowired
    public UserService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public LoginRes login(LoginReq loginReq) {
        User user = userRepository.findByUsername(loginReq.getUsername());
        if (user == null) {
            throw new UserNotFoundException("username", loginReq.getUsername());
        }
        if (BCrypt.checkpw(loginReq.getPassword(), user.getPassword())) {
            String tokenValue = UUID.randomUUID().toString();
            saveTokenToDB(user.getId(), tokenValue);
            return new LoginRes(user, tokenValue);
        } else {
            throw new WrongPasswordException();
        }
    }

    private void saveTokenToDB(String userId, String value) {
        Token curToken = new Token();
        curToken.setUserId(userId);
        curToken.setValue(value);
        tokenRepository.insert(curToken);
    }

}
