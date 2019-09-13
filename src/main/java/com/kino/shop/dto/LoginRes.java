package com.kino.shop.dto;

import com.kino.shop.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRes {

    private User user;
    private String token;
}
