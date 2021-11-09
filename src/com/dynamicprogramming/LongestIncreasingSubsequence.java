package com.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static  int max = 0;

    public static int LIS(int arr[], int n, int LISArr[]){
        if(n == 0) return 1;
        if(LISArr[n] != 0) return LISArr[n];

        for(int j = 0; j < n; j++){
            if(arr[j] < arr[n]) {
                LISArr[j] = LIS(arr, j, LISArr);
                max = Math.max(max, 1 + LISArr[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        int result = 0;
        for(int i=1; i < arr.length; i++) {
            result = LIS(arr, i, new int[arr.length]);
        }
        System.out.println("Longest Increasing Subsequence is of size: "+ result);
    }
}
