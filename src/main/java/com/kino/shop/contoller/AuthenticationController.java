package com.kino.shop.contoller;

import com.kino.shop.dto.LoginReq;
import com.kino.shop.dto.LoginRes;
import com.kino.shop.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Log in via username and password")
    @PostMapping("/login")
    public LoginRes login(@RequestBody LoginReq loginReq) {
        return userService.login(loginReq);
    }
}
