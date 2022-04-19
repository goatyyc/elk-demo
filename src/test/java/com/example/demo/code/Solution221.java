package com.example.demo.code;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/5 21:24
 */
public class Solution221 {
    public static void main(String[] args) {
        
//        [
//        ["1","1","1","1","0"],
//        ["1","1","1","1","0"],
//        ["1","1","1","1","1"],
//        ["1","1","1","1","1"],
//        ["0","0","1","1","1"]
//        ]

         char[][] matrix = {
                 {'1','0','1','0'},
                 {'1','0','1','1'},
                 {'1','0','1','1'},
                 {'1','1','1','1'}
         };
         
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 动态规划, dp[i][j] 代表当前坐标(i,j)的最大正方形面经
        int[][] dp = new int[row][col];

        // 递推公式: dp[i][j] = dp[i-1][j]==dp[i][j-1] ? dp[i-1][j]+1 : dp[i][j];
        // 初始化第一行、第一列
        for(int i=0;i<col;i++){
            dp[0][i] = matrix[0][i]=='1' ? 1:0;
        }
        for(int i=0;i<row;i++){
            dp[i][0] = matrix[i][0]=='1' ? 1:0;
        }


        // 遍历顺序
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    if(dp[i-1][j]==dp[i][j-1] && dp[i-1][j]==dp[i-1][j]){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else if(dp[i-1][j] !=0 && dp[i][j-1]!=0){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
//                    dp[i][j] = (dp[i-1][j]==dp[i][j-1] && dp[i-1][j]==dp[i-1][j]) ? dp[i-1][j-1]+1 : 1;
                }
            }
        }
        // 遍历找最大值
        int max = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max = Math.max(dp[i][j],max);
            }
        }
        return max;

    }
}
