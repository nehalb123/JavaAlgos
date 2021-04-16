package com.dynamicprogramming;

/**
 * You are given an integer N. Your task is to determine number of arrays of length N such that:
 *  1. Each value of array [0,5]
 *  2. XOR sum of all value of the array is zero.
 *
 *  Explanation: https://imgur.com/JK2xl9r
 *
 *  Rating: ⭐ ⭐ ⭐ ⭐ ⭐
 */
public class NumberOfArrays {

    static void countArrays(int N){
        int dp[][] = new int[N+1][8];
        dp[0][0] = 1;
        for(int i=1;i<N+1;i++){
            for(int j=0;j<8;j++){
                // k is XOR-sum of previously calculated number of arrays of length i-1.
                for(int k=0;k < 8;k++){
                    // x is a number we append to arrays of length i-1 so XOR-sum is j.
                    int x = j ^ k;
                    if(x <= 5){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }

        System.out.println("Total arrays possible: " + dp[N][0]);
    }

    public static void main(String[] args) {
        int N = 5;
        countArrays(N);
    }
}
