package com.example.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用Lock打印A B C
 * @author: yyc
 * @time: 2022/3/22 17:45
 */
public class PrintABLock {
    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        PrintABLock printABLock = new PrintABLock(10);
        new Thread(()->{
            printABLock.printLetter("A",0);
        },"A").start();
        new Thread(()->{
            printABLock.printLetter("B",1);
        },"B").start();
    }
    
    public PrintABLock(int times) {
        this.times = times;
    }
    private void printLetter(String name,int targetNum){
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state%2==targetNum){
                state++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }
}
