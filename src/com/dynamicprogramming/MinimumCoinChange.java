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

    public static final int LARGE_NUM = 1_000_000_000;

    static void print(int dp[][], int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int recursive(int idx, int sum, int coins[]){
        if(idx == 0) {
            if(sum % coins[idx] == 0) {
                return sum/coins[idx];
            } else {
                return LARGE_NUM;
            }
        }

        int notPick = recursive(idx-1, sum, coins);
        int pick = Integer.MAX_VALUE;
        if(coins[idx] <= sum){
            pick = 1 + recursive(idx, sum-coins[idx], coins);
        }
        return Math.min(notPick, pick);

    }





    public static void main(String[] args) {
        int sum = 10;
        int coins[] = {1, 6, 9};
        int result = recursive(coins.length-1, sum, coins);

        System.out.println(result);
    }
}
