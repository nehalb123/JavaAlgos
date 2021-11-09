package com.matrix;

/**
 * https://stackoverflow.com/questions/65510354/matrix-summation-challenge
 */
public class MatrixSummation {

    public static int[][] beforeMatrix(int afterMatrix[][]){
        int rows = afterMatrix.length;
        int cols = afterMatrix[0].length;

        for(int i=rows-1; i > 0; i--){
            for(int j=cols-1; j > 0; j--){
                afterMatrix[i][j] = afterMatrix[i][j] - afterMatrix[i-1][j] - afterMatrix[i][j-1] + afterMatrix[i-1][j-1];
            }
        }

        for(int i=rows-1; i > 0; i--){
            afterMatrix[i][0] -= afterMatrix[i-1][0];
        }
        for(int j=cols-1; j > 0; j--){
            afterMatrix[0][j] -= afterMatrix[0][j-1];
        }
        return afterMatrix;
    }

}
