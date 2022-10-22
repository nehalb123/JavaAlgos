package com.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {

    public static int recurse(int index, int wt[], int val[], int totalWeight){
        if(index == wt.length-1){
            if(wt[index] <= totalWeight) return val[index];
            else return 0;
        }
        int notPick = recurse(index+1, wt, val, totalWeight);
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= totalWeight){
            pick = val[index] + recurse(index+1, wt, val, totalWeight-wt[index]);
        }
        return Math.max(notPick, pick);
    }

    public static int recurseMemoization(int index, int wt[], int val[], int totalWeight, int dp[][]){
        if(index == wt.length-1){
            if(wt[index] <= totalWeight) return val[index];
            else return 0;
        }

        if(dp[index][totalWeight] != -1) return dp[index][totalWeight];

        int notPick = recurseMemoization(index+1, wt, val, totalWeight, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= totalWeight){
            pick = val[index] + recurseMemoization(index+1, wt, val, totalWeight-wt[index], dp);
        }
        dp[index][totalWeight] =  Math.max(notPick, pick);
        return dp[index][totalWeight];

    }

    public static int tabulated(int wt[], int val[], int totalWeight){
        // in recursive memoization solution, index range: [0, wt.length-1]
        // totalWeight range: [0, totalWeight]
        int dp[][] = new int[wt.length][totalWeight+1];
        // initialization with the help of base case
        for(int j = 0; j <= totalWeight; j++){
            dp[wt.length-1][j] = (j >= wt[wt.length-1]) ? val[wt.length-1] : 0;
        }
        // as we have filled up the last row we start from index = wt.length-2
        for(int ind = wt.length-2; ind >=0; ind--){
            for(int w = totalWeight; w >= 0; w--){
                int notPick = dp[ind+1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w){
                    pick = val[ind] + dp[ind+1][w-wt[ind]];
                }
                dp[ind][w] =  Math.max(notPick, pick);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][totalWeight];
    }

    public static int tabulatedOptimized(int wt[], int val[], int totalWeight){

        int after[] = new int[totalWeight+1];
        int curr[] = new int[totalWeight+1];

        for(int j = 0; j <= totalWeight; j++){
            after[j] = (j >= wt[wt.length-1]) ? val[wt.length-1] : 0;
        }
        // as we have filled up the last row we start from index = wt.length-2
        for(int ind = wt.length-2; ind >=0; ind--){
            for(int w = totalWeight; w >= 0; w--){
                int notPick = after[w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w){
                    pick = val[ind] + after[w-wt[ind]];
                }
                curr[w] =  Math.max(notPick, pick);
            }
            after = curr;
        }
        System.out.println(Arrays.toString(after));
        return after[totalWeight];
    }

    public static void computeMaxValue(int wt[], int val[], int totalWeight){
        /** Recursive solution */
        int result = recurse(0, wt, val, totalWeight);

        int dp[][] = new int[wt.length][totalWeight+1];
        for(int i=0; i<wt.length; i++){
            for(int j=0; j<=totalWeight; j++){
                dp[i][j] = -1;
            }
        }
        /** Memoized solution */
        int memoizedResult = recurseMemoization(0, wt, val, totalWeight, dp);
        /** Tabulated solution */
        int tabulatedResult = tabulated(wt, val,totalWeight);

        int tabulatedResultOptimized = tabulatedOptimized(wt, val, totalWeight);

        System.out.println("Max Value that you can pick: " + result);
        System.out.println("Max Value that you can pick(memoized): " + memoizedResult);
        System.out.println("Max Value that you can pick(tabulated): " + tabulatedResult);
        System.out.println("Max Value that you can pick(tabulated Optimized): " + tabulatedResultOptimized);
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
 * No. of items
 * 5
 * Total weight that knapsack can handle
 * 7
 * 5 <weight, value> pair:
 * 1 1
 * 2 1
 * 3 4
 * 4 5
 * 5 7
 *
 */