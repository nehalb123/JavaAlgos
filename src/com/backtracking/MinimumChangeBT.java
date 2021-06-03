package com.backtracking;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change? If it’s not possible to make change, print -1.
 *
 * Unbounded Knapsack problem
 */
public class MinimumChangeBT {

    static int count(int coins[], int amt, int i){
        if(amt == 0) return 0;
        if(amt<0) return Integer.MAX_VALUE-1;
        if(coins.length == i && amt > 0) return Integer.MAX_VALUE-1;

        return Math.min(1+count(coins, amt-coins[i], i), count(coins, amt, i+1));
    }

    static int count(int coins[], int amt){
        int i=0;
        return count(coins, amt, i);
    }

    static void countChange(int coins[], int amt){
        int change = count(coins, amt);
        if(change == Integer.MAX_VALUE-1){
            change = -1;
        }
        System.out.println("Change is: "+change);
    }

    public static void main(String[] args) {
        int coins[] = {1,2};
        int amount = 4;
        countChange(coins,amount);
    }
}
