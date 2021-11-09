package com.matrix;

public class PushAndFall {

    static void print(char dp[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void pushAndFall(char matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //int down = cols-1;
        for (int i = 0; i < rows; i++) {
            int down = cols - 1;
            for (int j = cols - 1; j >= 0; j--) {  //start looking from last column
                if (matrix[i][j] == '#') {
                    matrix[i][j] = '.';
                    matrix[i][down] = '#';
                    down--;
                } else if (matrix[i][j] == '*') {
                    down = j - 1;
                }
            }
        }

        char tempMatrix[][] = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempMatrix[i][j] = matrix[i][j];
            }
        }

        for (int j = 0; j < cols; j++) {
            int down = rows - 1;
            for (int i = rows - 1; i >= 0; i--) {
                if (tempMatrix[i][j] == '#') {
                    tempMatrix[i][j] = '.';
                    tempMatrix[down][j] = '#';
                    down--;
                } else if (tempMatrix[i][j] == '*') {
                    down = i - 1;
                }
            }
        }


        System.out.println("Printing Push");
        print(matrix, rows, cols);
        System.out.println("Printing Fall:");
        print(tempMatrix, rows, cols);

    }

    public static void main(String[] args) {
        char matrix[][] = {{'#','.','*','#','.'},{'.','.','.','.','.'},{'#','.','#','#','.'},{'#','.','.','.','#'}};
        pushAndFall(matrix);
    }
}
