package com.example.demo.common.exception;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/13 14:02
 */
public class MyExceptionTwo extends RuntimeException{
    public MyExceptionTwo() {
    }

    public MyExceptionTwo(String message) {
        super(message);
    }
}
