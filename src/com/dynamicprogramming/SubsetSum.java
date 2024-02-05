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

    /**
     * Recursive solution
     * @param i
     * @param sum
     * @param arr
     * @return
     */
    static boolean recursive(int i, int sum, int arr[]){
        if(sum == 0) return true;
        if(i == 0) return (arr[0] == sum);

        boolean notPick = recursive(i-1, sum, arr);
        boolean pick = false;
        if(arr[i] <= sum){
            pick = recursive(i-1, sum-arr[i], arr);
        }
        return pick || notPick;
    }

    /**
     * Tabulated solution of the above recursive solution
     * @param arr
     * @param sum
     * @return
     */
    static boolean tabulated(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];

        for(int i=0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i=1; i < n; i++){
            for(int t=1; t <= sum; t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(arr[i] <= t){
                    take = dp[i-1][t-arr[i]];
                }
                dp[i][t] = take || notTake;
            }
        }
        print(dp, n, sum+1);

        int i = n-1;
        int j = sum;
        ArrayList<Integer> subset = new ArrayList<>();
        while(i > 0){
            if(dp[i][j] != dp[i-1][j]){
                subset.add(arr[i]); //element on current row of matrix
                j = j - arr[i];
            }
            i = i -1;
        }
        if(j != 0 && arr[0] == j) subset.add(arr[0]);
        System.out.println(subset);

        return dp[n-1][sum];
    }

    /**
     * Older tabulation code which is not intuitive.
     * @param arr
     * @param sum
     */
    static void subsetSum(int arr[], int sum) {
        int rows = arr.length + 1;
        int cols = sum + 1;
        boolean dp[][] = new boolean[rows][cols];
        dp[0][0] = true;
        //populate first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = false;
        }
        //populate first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (dp[i - 1][j] || (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]])) {
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
        /*int arr[] = {10, 1, 7, 2, 9};
        int sum = 6;*/

        int arr[] = {3, 4, 5, 2};
        int sum = 6;
        // subsetSum(arr, sum);
        boolean result = recursive(arr.length-1, sum, arr);
        System.out.println(result);
        boolean res = tabulated(arr, sum);
    }
}
