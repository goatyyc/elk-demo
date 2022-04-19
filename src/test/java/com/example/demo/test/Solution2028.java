package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/27 16:00
 */
public class Solution2028 {

    public static void main(String[] args) {
        int[] rolls = {3,2,4,3}; 
        new Solution2028().missingRolls(rolls,4,2);
    }
    List<Integer> result;

    List<Integer> list;
    int size = 0;
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = n+m;
        int[] ans = new int[total];
        int sum = 0;
        for(int i=0;i<m;i++){
            ans[i] = rolls[i];
            sum += rolls[i];
        }
        int all = mean*total;
        int diff = all - sum;
        // 构造res个总和为diff的数 范围在[1,6]
        // 回溯
        list = new ArrayList<>();
        result = new ArrayList<>();

        int[] arr = {1,2,3,4,5,6};
        size = n;
        backtracking(arr,diff,0);
        // 输出list
        for(int i:list){
            System.out.print(i+" ");
        }
        int index = 0;
        for(int i=m;i<total;i++){
             ans[i] = result.get(index);
             index++;
        }
        return ans;
    }
    public void backtracking(int[] arr,int target,int startIndex){
        // 终止条件
        if(list.size()==size && target!=0){
            return;
        }
        if(target==0 && list.size()==size){
//            System.out.println("找到一个解");
            for (int i = 0; i < size; i++) {
                result.add(list.get(i));
            }
            return;
        }
        for(int i=startIndex;i<arr.length && target>=arr[i];i++){
            list.add(arr[i]);
            backtracking(arr,target-arr[i],i);
            list.remove(list.size()-1);
        }

    }
}
