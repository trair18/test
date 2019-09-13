package com.kino.shop.exception.handler;

import com.kino.shop.dto.ErrorDto;
import com.kino.shop.exception.UserNotFoundException;
import com.kino.shop.exception.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode("USER_NOT_FOUND");
        errorDto.setStatus(404);
        Map<String, Object> details = new HashMap<>();
        details.put(exception.getProperty(), exception.getValue());
        errorDto.setDetails(details);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public ResponseEntity<Object> exception(WrongPasswordException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode("WRONG_PASSWORD");
        errorDto.setStatus(400);
        Map<String, Object> details = new HashMap<>();
        errorDto.setDetails(details);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
