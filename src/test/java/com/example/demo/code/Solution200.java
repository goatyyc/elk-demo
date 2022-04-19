package com.example.demo.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/5 19:15
 */
public class Solution200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        
//[
// ["1","0","1","1","1"],
// ["1","0","1","0","1"],
// ["1","1","1","0","1"]]
        
        solution200.numIslands(grid);
    }

    boolean[][] used;
    public int numIslands(char[][] grid) {
        // 广度优先
        // 维护一个队列，对这个队列上下左右入队后，修改为0
        // 直到队列为空，进行下一次搜索
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    q.offer(i*col+j);
                    while (!q.isEmpty()){
                        int id = q.poll();
                        int r = id/col;
                        int c = id%col;
                        grid[r][c] = '0';
                        if(r-1>=0 && grid[r-1][c]=='1'){
                            q.offer((r-1)*col+c);
                            grid[r-1][c] = '0';
                        }
                        if(r+1<row && grid[r+1][c]=='1'){
                            q.offer((r+1)*col+c);
                            grid[r+1][c] = '0';
                        }
                        if(c-1>=0 && grid[r][c-1]=='1'){
                            q.offer(r*col+c-1);
                            grid[r][c-1] = '0';
                        }
                        if(c+1<col && grid[r][c+1]=='1'){
                            q.offer(r*col+c+1);
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }
        return count;
        
    }
    
}
