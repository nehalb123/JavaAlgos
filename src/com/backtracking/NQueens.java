package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {


    static boolean isSafe(int row, int col, List<String> board){
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col>= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while(col >= 0 && row < board.size()){
            if(board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    static void solve(int col, List<String> board, List<List<String>> result, int n){
        if(col == n){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row<n; row++){
            if(isSafe(row, col, board)){
                String line  = board.get(row);
                String newLine = line.substring(0, col) + "Q" + line.substring(col+1);
                board.set(row, newLine);
                solve(col+1, board, result, n);
                String resetNewLine = line.substring(0, col) + "." + line.substring(col+1);
                board.set(row, resetNewLine);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        char[] rows = new char[n];
        Arrays.fill(rows, '.');

        String rowString = new String(rows);
        for(int i=0; i<n; i++){
            board.add(rowString);
        }

        solve(0, board, result, n);

        System.out.println(result);
    }
}
