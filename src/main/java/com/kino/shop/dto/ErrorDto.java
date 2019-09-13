package com.kino.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private String errorCode;
    private Integer status;
    private Map<String, Object> details;
}
