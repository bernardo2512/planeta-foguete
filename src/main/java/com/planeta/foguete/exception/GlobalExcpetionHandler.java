package com.planeta.foguete.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExcpetionHandler {
    
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity geralException(Exception e, HttpServletRequest request){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
