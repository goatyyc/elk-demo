package com.example.demo.test;

/**
 * @description: 两个线程交替打印AB
 * @author: yyc
 * @time: 2022/3/22 16:46
 */
public class PrintAB {

    private static Object lock = new Object();
    private int times;
    private int state;

    public PrintAB(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintAB printAB = new PrintAB(100);
        new Thread(()->{
            printAB.printLetter("A",0);
        },"A").start();
        new Thread(()->{
            printAB.printLetter("B",1);
        },"B").start();
    }

    private void printLetter(String name,int targetState){
        for (int i = 0; i < times; i++) {
            synchronized (lock){
                while (state%2 != targetState){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                lock.notifyAll();
            }
        }
    }


}
