package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nehal Borole
 *
 * 0/1 Knapsack Problem - Given items of certain weights,values and maximum allowed weight,
 * pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * https://imgur.com/NxemNps
 */
public class Knapsack01 {

    //Time Complexity: O(mn)
    static void computeMaxValue( int weight[], int val[], int totalWeight){
        int dp[][] = new int[weight.length+ 1][totalWeight+1];
        for(int i=1; i < dp.length; i++){
            for(int j=1; j < dp[i].length; j++){
                if(j-weight[i-1] >= 0){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-weight[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        /**
         * Add selected item to the list.
         */
        int i = weight.length;
        int j = totalWeight;
        ArrayList<Integer> weights = new ArrayList<>();
        while(i > 0){
            if(dp[i-1][j] != dp[i][j]){
                weights.add(weight[i-1]);
                j = j-weight[i-1];
                i = i-1;
                continue;
            }
            i = i-1;
        }
        System.out.println(weights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of items");
        int items = sc.nextInt();
        System.out.println("Total weight that knapsack can handle");
        int totalWeight = sc.nextInt();
        int weight[] = new int[items];
        int val[] = new int[items];
        System.out.println(items + " <weight, value> pair:");
        for(int i=0;i<items;i++){
            weight[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        computeMaxValue(weight, val, totalWeight);
    }
}

/**
 Testcase:
 5
 7
 1 1
 2 1
 3 4
 4 5
 5 7
 */
