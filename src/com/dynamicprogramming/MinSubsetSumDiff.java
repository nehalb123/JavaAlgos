package com.dynamicprogramming;

import java.util.ArrayList;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum.
 * TODO : Diagram?
 * Rating: ⭐ ⭐ ⭐ ⭐ ⭐
 */
public class MinSubsetSumDiff {

    static void minDiff(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
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
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int s1 = i;
            int s2 = sum - i;
            if (dp[rows - 1][i] == true && diff > Math.abs(s1 - s2)) {
                diff = Math.abs(s1 - s2);
            }
        }

        System.out.println(diff);

        /**
         * For arr=[2,4,100] sum/2 is not going to be true always. Hence find the column first.
         */
        int j = sum / 2;
        int i = rows - 1;
        for(int k = j; k >=0; k++){
            if(dp[i][k]){
                j = k;
                break;
            }
        }

        ArrayList<Integer> subset1 = new ArrayList<>();
        ArrayList<Integer> subset2 = new ArrayList<>();
        while (i > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                subset1.add(arr[i - 1]); //element on current row of matrix
                j = j - arr[i - 1];
                i = i - 1;
                continue;
            }
            subset2.add(arr[i - 1]);
            i = i - 1;
        }
        System.out.println(subset1);
        System.out.println(subset2);
    }

    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        minDiff(arr);
    }
}
