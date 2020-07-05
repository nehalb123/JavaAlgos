package com.matrix;

public class SetMatrixZeros {


    static void setZeroes(int arr[][]) {
        boolean firstCol = false;
/*
* Idea: Use the first row and first column as a flag. This would determine if a row or column is set to 0.
*
* */
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0] == 0){
                firstCol = true;
            }
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for (int i=1;i<arr.length;i++) {
            for (int j=1;j<arr[i].length;j++) {
                if(arr[i][0] == 0 || arr[0][j]==0){
                    arr[i][j] = 0;
                }

            }
        }

        if(arr[0][0] == 0){
            for (int j=0;j<arr[0].length;j++){
                arr[0][j] = 0;
            }
        }
        if(firstCol){
            for (int i=0;i<arr.length;i++){
                arr[i][0] = 0;
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

