package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

        public static int orangesRotting(int[][] grid) {
            Queue<Integer> q = new LinkedList();
            int nc = grid[0].length;
            int nr = grid.length;
            int freshOranges = 0;

            for(int i=0; i < nr; i++){
                for(int j=0; j < nc; j++){
                    if(grid[i][j] == 2){
                        q.offer(i*nc+j);
                    } else if(grid[i][j] == 1){
                        freshOranges++;
                    }
                }
            }
            int time = 0;
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            if(freshOranges == 0) return 0;

            while(!q.isEmpty()){
                time++;
                int size = q.size();
                for(int i=0; i < size; i++){
                    int num = q.poll();
                    int row = num/nc;
                    int col = num%nc;
                    for(int dir[]: dirs){
                        int x = row + dir[0];
                        int y = col + dir[1];

                        if(x < 0 || y < 0 || x >= nr || y >= nc || grid[x][y] == 0 || grid[x][y] == 2) continue;

                        grid[x][y] = 2;
                        q.offer(x*nc+y);

                        freshOranges--;
                    }
                }
            }

            return freshOranges == 0 ? time-1 : -1;
        }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int res = orangesRotting(grid);
        System.out.println(res);

    }

}
