package com.example.demo.controller;

import com.example.demo.common.exception.MyException;
import com.example.demo.common.exception.MyExceptionTwo;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/31 14:47
 */
@Slf4j
@RestController
public class MyTestController {
    
    @PostMapping("/user")
    public void getUser(@Validated @RequestBody User user){
        List<Integer> list = new ArrayList<>();
        list.set(1,1);
        log.info("user:{}",user);
    }
    
    @GetMapping("/test")
    public void test(Integer index) throws MyException {
        if(index>10){
            throw new MyException();
        }
    }
    
    @GetMapping("/test2")
    public void test2(Integer index) {
        Random random = new Random();

    }
    
}
