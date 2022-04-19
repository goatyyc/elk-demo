package com.example.demo.test;

/**
 * @description: 交替打印FooBar
 * @author: yyc
 * @time: 2022/3/21 10:56
 */
public class MultipleThread {

    public Object lock = new Object();
    
    public static void main(String[] args) {
        
    }
    
    class printFooThread extends Thread{
        @Override
        public void run() {
            System.out.print("Foo");
        }
    }

    class printBarThread extends Thread{
        @Override
        public void run() {
            System.out.print("Bar");
        }
    }
    
    
}
