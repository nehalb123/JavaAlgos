package com.dynamicprogramming;


/**
 * 322. Coin Change
 * Problem Statement: Given a sum and unlimited supply of coins of certain denomination, find minimum change
 * that can form the sum.
 * Sum = 11
 * C = {1,2,5}
 * Change = 3
 *
 * https://imgur.com/XrQZXVN
 */
public class MinimumCoinChange {

    static void print(int dp[][], int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void optimizedComputed(int N, int coins[]){
        /**
         * Instead of using a 2D array, we can optimize the space by using 1d array.
         */
        int change[] = new int[N+1];
        change[0] = 0;
        for(int i=1;i<N+1;i++){
            change[i] = Integer.MAX_VALUE-1;
        }
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<N+1;j++){
                if(j>=coins[i]){
                    change[j] = Math.min(change[j], change[j-coins[i]] + 1);
                }
            }
        }
        System.out.println("No. of ways: " + (change[N] == Integer.MAX_VALUE-1 ? -1 : change[N]));
    }

    static void compute(int N, int coins[]){
        int len = coins.length;
        int dp[][] = new int[len+1][N+1];

        //Sum of 0 can be made by choosing 0 coins
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        //A coin of 0 denomination can't be used to make sum>=1.
        for(int j=1; j < dp[0].length; j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j >= coins[i-1]){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp, len+1, N+1);
        System.out.println("No. of ways: " + (dp[len][N] == Integer.MAX_VALUE-1 ? -1 : dp[len][N]));

    }

    public static void main(String[] args) {
        int N = 11;
        int coins[] = {9, 6, 5, 1};
        compute(N, coins);
        optimizedComputed(N, coins);
    }
}
