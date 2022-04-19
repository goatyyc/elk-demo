package com.example.demo.test;

import java.util.Hashtable;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/17 0:28
 */
import java.util.*;
import java.lang.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 只针对一组
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int num = (int) Math.pow(a,b);

        System.out.println(get(num,c));

    }

    public static int get(int num,int z){
        if(num<z){
            return num;
        }else{
            // 将num转换为K进制 的 各位数之和;
            int temp = change(num,z);
            return get(temp,z);
        }
    }
    public static int change(int num,int k){
        int sum = 0;
        while(num>0){
            sum += num % k;
            num /= k;
        }
        return sum;
    }
}
