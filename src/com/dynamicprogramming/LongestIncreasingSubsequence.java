package com.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public static int LISBottomUp(int arr[]){
        int len = arr.length;
        int LISArr[] = new int[len];

        Arrays.fill(LISArr, 1);
        int max = 1;
        for(int i=1; i < len; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j] && LISArr[i] < LISArr[j]+1){
                    LISArr[i] = LISArr[j]+1;
                    if(LISArr[i] > max){
                        max = LISArr[i];
                    }
                }
            }
        }

        return max;
    }

    /**
     * LIS(arr, n) = 1 + max( LIS(arr, j) ) max computed over all j, 0<=j<n and arr[j]<arr[n]`
     */
    public static int LIS(int arr[], int n, int LISArr[]){
        if(n == 0){
            LISArr[n] = 1;
            return 1;
        }
        if(LISArr[n] != 0) return LISArr[n];
        int temp = 0;
        int max = 1;
        for(int j = 0; j < n; j++){
            temp = LISArr[j];
            if(temp == 0){
                temp = LIS(arr, j, LISArr);
            }
            if(arr[j] < arr[n]) {
                temp++;
            }
            if(temp > max && arr[j] < arr[n]){
                max = temp;
            }
        }
        LISArr[n] = max;
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {4,10,4,3,8,9};
        int result = 0;
        int temp = 0;
        int LISArr[] = new int[arr.length];
        LISArr[0] = 1;
        for(int i=1; i < arr.length; i++) {
            temp = LIS(arr, i, LISArr);
            if(temp > result){
                result = temp;
            }
        }
        System.out.println("Longest Increasing Subsequence is of size: "+ result);

        result = LISBottomUp(arr);
        System.out.println("Longest Increasing Subsequence(Bottom Up): "+ result);
    }
}
