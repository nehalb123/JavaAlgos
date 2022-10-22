package com.graph;

public class NumberOfIslands {

    private static void dfs(char[][] grid, int i, int j){
        //if out of bounds and visited return 0;
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        // mark visited
        grid[i][j] = '0';

        //traverse
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid =  {
                              {'1','1','1','1','0'},
                              {'1','1','0','1','0'},
                              {'1','1','0','0','0'},
                              {'0','0','0','0','0'}
                          };

        int count = numIslands(grid);
        System.out.println("Number of islands: " + count);
    }
}
