package com.example.demo.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 15:10
 */
@Slf4j
public class WaitNotifyTest {
    
    private static Object lock = new Object();
    
    /**
     * 两个线程交替打印AB 10次
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        lock.wait();
        Thread.sleep(2000);
    }
    
}
