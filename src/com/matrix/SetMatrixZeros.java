package com.matrix;

public class SetMatrixZeros {

    static void setZeroes(int arr[][]) {

        /*
        * Idea: Use the first row and first column as a flag. This would determine if a row or column is set to 0.
        * */
        int H = arr.length;
        int W = arr[0].length;
        boolean firstRowZero = false;
        //check if first row has zero because we will mutate it later
        for(int col=0; col < W; col++){
            if(arr[0][col] == 0){
                firstRowZero = true;
            }
        }
        for(int row = 0; row < H; row++){
            for(int col = 0; col < W; col++){
                if(arr[row][col] == 0){
                    arr[0][col] = 0;
                }
            }
        }

        for(int row = 1; row < H; row++){
            boolean containsZero = false;
            for(int col = 0; col< W; col++){
                if(arr[row][col] == 0){
                    containsZero = true;
                    break;
                }
            }
            for(int col = 0; col < W; col++){
                if(containsZero || arr[0][col] == 0){
                    arr[row][col] = 0;
                }
            }
        }
        if(firstRowZero){
            for(int col=0; col < W; col++){
                arr[0][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,2,3,0},{4,0,6,1},{7,8,9,4}};
        System.out.println("Before:");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        setZeroes(arr);
        System.out.println("After:");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

