package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Rating: ⭐ ⭐ ⭐ ⭐ ⭐
 *
 * white : the vertex v is not yet discovered.
 *
 * gray : v has already been discovered , but all the vertices that are reachable from v are not yet discovered. so the vertex v is still in the stack.
 *
 * black: v is already pop out of stack.discovered and finished.
 */

public class CourseSchedule {

    static boolean dfs(HashMap<Integer, List<Integer>> graph, int color[], int i){
        color[i] = 1; //gray
        boolean temp = true;
        if(graph.get(i) != null) {
            for(int adj : graph.get(i)){
                if(color[adj] == 1) return false;
                if(color[adj] == 0) {
                    temp = temp & dfs(graph, color, adj);
                }
            }
        }
        color[i] = 2; //black
        return temp;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(int[] item: prerequisites){
            if(graph.containsKey(item[1])){
                graph.get(item[1]).add(item[0]);
            } else{
                List<Integer> courses = new ArrayList();
                courses.add(item[0]);
                graph.put(item[1], courses);
            }
        }

        int color[] = new int[numCourses]; //all white
        for(int[] item: prerequisites){
            if(color[item[1]] == 0){
                if(!dfs(graph, color, item[1])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int prerequisites[][] = {{1,0},{0,1}};
        int numCorses = 2;
        boolean res = canFinish(numCorses, prerequisites);
        System.out.println(res);
    }
}


