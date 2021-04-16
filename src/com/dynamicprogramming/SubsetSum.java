package com.dynamicprogramming;

import java.util.ArrayList;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 *
 * Rating:  ⭐ ⭐ (Easy)
 */
public class SubsetSum {

    static void print(boolean dp[][], int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void subsetSum(int arr[], int sum) {
        int rows = arr.length + 1;
        int cols = sum + 1;
        boolean dp[][] = new boolean[rows][cols];
        dp[0][0] = true;
        for (int i = 1; i < cols; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (dp[i - 1][j] || j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int i = rows-1;
        int j = cols-1;
        ArrayList<Integer> subset = new ArrayList<>();
        while(i > 0){
            if(dp[i][j] != dp[i-1][j]){
                subset.add(arr[i-1]); //element on current row of matrix
                j = j - arr[i-1];
            }
            i = i -1;
        }
        System.out.println(subset);

        print(dp, rows, cols);
    }

    public static void main(String[] args) {
        int arr[] = {2,4,2,3};
        int sum = 5;
        subsetSum(arr, sum);
    }
}
