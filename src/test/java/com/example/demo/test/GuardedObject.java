package com.example.demo.test;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 17:15
 */
public class GuardedObject {
    
}

class Guarded{
    private Object obj;
    public Object get(){
        synchronized (this){
            new Thread();
            while (obj==null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }
    }
    public void complete(Object response){
        synchronized (this){
            this.obj = response;
            this.notifyAll();
        }
    }
}