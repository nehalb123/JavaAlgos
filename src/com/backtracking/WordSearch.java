package com.backtracking;

/**
 * Backtracking solution
 *
 * Time Complexity: O(n*m*dfs) = O(n * m * len(word))
 */
public class WordSearch {

    public static boolean dfs(char[][] board, int rows, int cols, String word, int index){
        if(index == word.length()) return true;
        //no need to check if revisited as * is not present in word.
        if(rows < 0 || cols < 0 || rows >= board.length || cols >= board[0].length || word.charAt(index) != board[rows][cols]) return false;

        //mark visited
        board[rows][cols] = '*';
        boolean res = dfs(board, rows+1, cols, word, index+1) ||
                dfs(board, rows-1, cols, word, index+1) ||
                dfs(board, rows, cols+1, word, index+1) ||
                dfs(board, rows, cols-1, word, index+1);
        //reset
        board[rows][cols] = word.charAt(index);
        return res;
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;


    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
