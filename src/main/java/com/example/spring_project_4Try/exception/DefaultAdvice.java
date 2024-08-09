package com.example.spring_project_4Try.exception;

import com.example.spring_project_4Try.programObject.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

@ExceptionHandler(BusinessException.class)
public ResponseEntity<Response> handleException(BusinessException e){
    Response response = new Response();
    return new ResponseEntity<>(response, HttpStatus.OK);
}
}