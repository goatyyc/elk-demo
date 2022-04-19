package com.example.demo.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/4 19:01
 */
public class AutoMain {
    
    static AtomicInteger atomicInteger;
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 50000; i++) {
                        atomicInteger.getAndIncrement();
                    }
                }
        );
        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 50000; i++) {
                        atomicInteger.getAndIncrement();
                    }
                }
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicInteger.get());    // 100000
    }
}
