package com.example.demo.threadtest;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/8 19:59
 */
@Slf4j
public class ThreadTwoStep {

    public static void main(String[] args) throws InterruptedException {
        ThreadTwoStep twoStep = new ThreadTwoStep();
        twoStep.start();
        
        Thread.sleep(3500);
        twoStep.stop();
    }
    
    private Thread monitor;
    public void start(){
        monitor = new Thread(
                ()->{
                    while (true){
                        Thread current = Thread.currentThread();
                        if(current.isInterrupted()){
                            log.debug("do something");
                            break;
                        }
                        // 没被打断，进行睡眠，监控
                        try {
                            Thread.sleep(1000);
                            log.debug("执行监控");      // 情况1
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            // 情况2
                            // 重新设置打断标记
                            current.interrupt();
                        }
                    }
                }
        );
        
        monitor.start();
    }
    
    public void stop(){
        monitor.interrupt();
    }
}
