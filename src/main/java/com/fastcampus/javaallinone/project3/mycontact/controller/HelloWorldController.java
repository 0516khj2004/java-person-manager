package com.fastcampus.javaallinone.project3.mycontact.controller;

import com.fastcampus.javaallinone.project3.mycontact.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value =  "/api/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }

    @GetMapping(value =  "/api/helloException")
    public String helloException(){
        throw  new  RuntimeException("Hello RuntimeException");
    }
//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex){
//        return  new ResponseEntity<>(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
//                "알수 없는 서버 오류가 발생했습니다"),HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
