package com.backtracking;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change? If it’s not possible to make change, print -1.
 */
public class MinimumChangeBT {

    static int count(int coins[], int amt){
        if(amt == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){   //every recursive call will have branches
            if(coins[i] <= amt){
              int subRes =  count(coins,amt-coins[i]); //include the coin
                if (subRes != Integer.MAX_VALUE && subRes+1 < res){
                    res = subRes + 1;
                }
            }
        }
        return res;
    }

    static void countChange(int coins[], int amt){
        int change = count(coins, amt);
        System.out.println("Change is: "+change);
    }

    public static void main(String[] args) {
        int coins[] = {1, 6, 5, 9};
        int amount = 11;
        countChange(coins,amount);
    }
}
