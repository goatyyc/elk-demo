package com.example.demo.code;

/**
 * @description: 最长公共子序列
 * @author: yyc
 * @time: 2022/4/13 16:36
 */
public class Solution1143 {

    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        solution1143.longestCommonSubsequence("abcdefg","bcd");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        
        // 暴力法: 双层循环
        int len1 = text1.length();
        int len2 = text2.length();
        int max = 0;
        int start = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int l = i,r = j;
                
                if(text1.charAt(i)==text2.charAt(j)){
                    int len = 0;
                    while(l<len1 && r<len2 && text1.charAt(l)==text2.charAt(r)){
                        l++;
                        r++;
                        len++;
                    }
                    if(len>max){
                        max = len;
                        start = i;
                    }
                    if(l<len1){
                        i = i+l;
                    }
                }
            }
        }
        // 返回
        String ans = text1.substring(start,start+max);
        System.out.println("截取出来的最长子序列:"+ans);
        System.out.println("len:"+max);
        return max;
    }
    
}
