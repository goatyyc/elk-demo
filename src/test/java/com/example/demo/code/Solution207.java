package com.example.demo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/6 10:56
 */
public class Solution207 {
    public boolean canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(findCircle(i,visited,graph)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean findCircle(int node,int[] visited,List<List<Integer>> graph){
        if(visited[node]==1){
            return true;
        }
        visited[node] = 1;
        for (Integer next : graph.get(node)) {
            if(findCircle(next,visited,graph)){
                return true;
            }
        }
        return false;
    }
}
