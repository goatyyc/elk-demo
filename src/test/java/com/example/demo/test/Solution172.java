package com.example.demo.test;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/25 23:11
 */
public class Solution172 {

    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.trailingZeroes(15));
    }
    
    public int trailingZeroes(int n) {
        // dp数组 dp[i][0] 代表当前i!有多少个0，还需要维护乘积，因此可以用二维数组
        int[][] dp = new int[n+1][2];
        // 递推公式 dp[i][0] = dp[i-1] + n*dp[i][1]得出的0个数
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i=2;i<=n;i++){
            int count = countZero(dp[i-1][1],i);
            dp[i][0] = dp[i-1][0] + count;
            dp[i][1] = dp[i-1][1]*i;
        }
        // 打印dp数组
        for (int i = 0; i <=n; i++) {
            System.out.print(dp[i][1]+" ");
        }
        System.out.println("==============");
        for (int i = 0; i <=n; i++) {
            System.out.print(dp[i][0]+" ");
        }
        System.out.println("==============");
        return dp[n][0];
    }
    // 计算a*b有多少个0
    public int countZero(int a,int b){
        int n = a*b;
        int count = 0;
        while(n%10==0){
            count++;
            n/=10;
        }
        return count;
    }

}
