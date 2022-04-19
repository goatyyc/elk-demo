package com.example.demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/5 16:30
 */

public class ThreadTest {

    public static void main(String[] args) {
        // 第一种
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("run1");
//            }
//        };
//        t1.start();
//
//        Thread thread = new Thread(()->{
//            System.out.println("test");
//        });
//        thread.start();

        // 第二种
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//        };
//        Thread t2 = new Thread(runnable);
//        t2.start();

        // 第三种
        FutureTask<Integer> futureTask = new FutureTask<>(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println("logging");
                        Thread.sleep(10000);
                        return 100;
                    }
                }
        );
        Thread thread = new Thread(futureTask,"A");
        thread.start();
        try {
            Integer integer = futureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
    }
    
}
