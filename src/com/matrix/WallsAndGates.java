package com.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static int EMPTY = Integer.MAX_VALUE;
    public static int GATE = 0;


    static void wallsAndGates(int rooms[][]){
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int []> q = new LinkedList<>();

        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(rooms[i][j] == GATE){
                    q.add(new int[]{i , j});
                }
            }
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int cell[] = q.poll();
            int row = cell[0];
            int col = cell[1];
            for(int i = 0; i < 4; i++){
                int r = row + dx[i];
                int c = col + dy[i];

                if(r < 0 || c < 0 || r >= rows || c >= cols || rooms[r][c] != EMPTY){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r,c});
            }
        }

    }

    public static void main(String[] args) {
        int rooms[][] = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
    }
}
