package com.example.demo.code;

/**
 * @description: 不同路径
 * @author: yyc
 * @time: 2022/3/20 13:29
 */
public class Solution68 {
    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        solution68.uniquePaths(3,7);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 递推公式 dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // 遍历顺序
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[m-1][n-1];
    }
}
