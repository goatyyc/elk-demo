package com.example.demo.test;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/26 16:58
 */
public class StackTest {
    public static void main(String[] args) {
        Person a = new Person();
        a.age = 10;
        a.name = "zs";
        Person b = new Person();
        b.name = "ls";
        b.age = 16;
        StackTest test = new StackTest();
        test.swap(a,b);
        System.out.println("a的名字:"+a.name);
        System.out.println("b的名字:"+b.name);
    }
    
    public void swap(Person a,Person b){
//        String temp = a.name;
//        a.name = b.name;
//        b.name = temp;
        Person temp = a;
        a = b;
        b = temp;
        // 输出
        System.out.println("a的名字:"+a.name);
        System.out.println("b的名字:"+b.name);
    }
}

class Person{
    String name;
    int age;
}