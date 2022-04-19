package com.example.demo.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/2 16:37
 */
public class Main {
    static int count = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 50000; i++) {
                        count++;
                    }
                }
        );
        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 50000; i++) {
                        count++;
                    }
                }
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
        
    }

}
