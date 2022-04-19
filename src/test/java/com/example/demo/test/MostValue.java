package com.example.demo.test;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/24 13:56
 */
public class MostValue {

    public static void main(String[] args) {
        
    }
    
    public int maxValue(int[][] grid){
        // dp，每次向右，或向下，那么对应的
        // dp[j] 代表从左上角开始到达当前位置，能拿到的最多价值的礼物
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        // 递推公式 dp[i][j] = max(dp[i-1][j],dp[i][j-1])+grid[i][j];
        // 初始化数组:根据递推公式，每次需要从上或左边，因此初始化第一行和第一列
        // 初始化第一行
        int row = 0;
        for(int i=0;i<n;i++){
            row += grid[0][i];
            dp[i] = row;
        }

        // 遍历顺序，先行后列
        for(int i=1;i<m;i++){
            // 反序
            dp[0] += grid[i][0];
            for(int j=n-1;j>0;j--){
                dp[j] = Math.max(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }
    
}
