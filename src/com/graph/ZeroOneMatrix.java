package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    /**
     * https://imgur.com/PZfkgVg
     */
    static class PointData{
        int x;
        int y;
        PointData(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    boolean isValid(int x, int y, int matrix[][]){
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length)
            return false;
        return true;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int dist[][] = new int[rows][cols];
        for(int[] row: dist){
            Arrays.fill(row, -1);
        }

        Queue<PointData> q = new LinkedList();
        for(int i=0;i< rows;i++){
            for(int j=0;j< cols;j++){
                if(matrix[i][j] == 0){
                    dist[i][j] = 0;
                    q.offer(new PointData(i,j)); //enqueue source nodes i.e. 0s
                }
            }
        }

        int dir[][] = {{-1, 0},{1, 0},{0, 1},{0, -1}};  //to look in all four directions
        while(!q.isEmpty()){
            PointData curr = q.poll();
            for(int t=0; t < 4; t++){
                int neighbour_x = curr.x + dir[t][0];
                int neighbour_y = curr.y + dir[t][1];
                if(isValid(neighbour_x, neighbour_y, matrix) && dist[neighbour_x][neighbour_y] == -1){  //if valid index and unvisited
                    dist[neighbour_x][neighbour_y] = dist[curr.x][curr.y] + 1;
                    q.offer(new PointData(neighbour_x, neighbour_y));
                }
            }
        }
        return dist;
    }

}
