package com.kino.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Token {

    @Id
    private String id;
    private String userId;
    private String value;
}
