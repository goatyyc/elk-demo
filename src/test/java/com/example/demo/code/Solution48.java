package com.example.demo.code;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/12 15:56
 */
public class Solution48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution48.rotate(matrix);
    }
    
    public void rotate(int[][] matrix) {
        // 循环替换四个数...
        // (i,j) -> (j,n-1-i) -> (n-1-i,n-1-j) -> (n-1-j,i) -> (i,j)
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }   
}
