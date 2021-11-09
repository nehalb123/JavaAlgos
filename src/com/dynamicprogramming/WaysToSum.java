package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 518. Coin Change 2
 * For example: total=5 and k=3 ie (1 to 3), no. of ways = 5, the different ways are:
 *
 * [1+1+1+1+1]
 * [1+1+1+2]
 * [1+2+2]
 * [1+1+3]
 * [2+3]
 *
 * https://imgur.com/d3D5vz3
 */
public class WaysToSum {

    static int ways(int total, int k){

        int dp[][] = new int[k+1][total+1];
        for(int i=1;i < total+1; i++){
            dp[1][i] = 1;
        }
        for(int i=1; i < k+1; i++){
            dp[i][0] = 1;
        }

        for(int i=2;i< k+1;i++){
            for(int j=1; j < total+1;j++){
                if(j >= i){
                    dp[i][j] = dp[i-1][j] + dp[i][j-i]; //ways to sum for (k-1) elements + including this element
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[k][total];
    }

    public static void main(String[] args) {
        int ways = ways(8,2);
        System.out.println("Number of ways to make total: "+ ways);
    }
}
