package com.backtracking;

public class SudokuSolver {

    static boolean isRowSafe(int board[][], int row, int num){
        for(int j=0;j<4;j++){
            if(board[row][j] == num){
                return false;
            }
        }
        return true;
    }

    static boolean isColSafe(int board[][], int col, int num){
        for(int i=0;i<4;i++){
            if(board[i][col] == num){
                return false;
            }
        }
        return true;
    }

    static boolean isBoxSafe(int board[][], int row,int col, int num){
        int rowStart = row - row%2;
        int colStart = col - col%2;
        for(int i=rowStart;i<rowStart+2;i++){
            for(int j=colStart;j<colStart+2;j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canSolveSudoku(int board[][], int row, int col, int num){
        //check row,col and box
        if(!isRowSafe(board,row,num)){
            return false;
        }

        if(!isColSafe(board,col,num)){
            return false;
        }

        if(!isBoxSafe(board,row,col,num)){
            return false;
        }

        return true;

    }

    static boolean sudokuSolver(int board[][]){
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0){
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(isEmpty){
                break;
            }
        }

        if(!isEmpty){
            return true;
        }

        for(int num=1;num<=4;num++){
            if(canSolveSudoku(board,row,col,num)){
                board[row][col] = num;
                if(sudokuSolver(board)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int board[][] = new int[][]{{1,0,2,4},{0,0,3,1},{3,4,0,2},{0,0,4,0}};
        sudokuSolver(board);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
