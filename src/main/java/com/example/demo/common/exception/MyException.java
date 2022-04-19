package com.example.demo.common.exception;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/13 14:01
 */
public class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
