package com.example.demo.threadtest;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/8 11:04
 */
@Slf4j
public class SleepTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("线程sleep");
                Thread.sleep(1000);
                log.debug("线程sleep结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        t1.start();
        log.debug("打断线程");
        t1.interrupt();
    }
    
}
