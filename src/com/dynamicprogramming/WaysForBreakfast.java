package com.dynamicprogramming;

/**
 * Find the number of ways you can have breakfast in 'n' days, given
 * Bread-butter can be eaten every day, Pizza can be eaten every alternate day and Burger can be eaten every two days.
 */
public class WaysForBreakfast {

    static void waysToEat(int n){
        int dp[][] = new int[3][n+1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;
        for(int i=2;i<=n;i++){
            dp[0][i] = dp[0][i-1] + dp[1][i-1] + dp[2][i-1]; //bread-butter
            dp[1][i] = dp[0][i-1] + dp[2][i-1]; //pizza
            dp[2][i] = dp[0][i-1] + dp[1][i-1] - 2*dp[2][i-2]; //burger
        }
        int totalWays = dp[0][n] + dp[1][n] + dp[2][n];
        System.out.println("Ways to eat breakfast: " + totalWays);
    }

    public static void main(String[] args) {
        int n = 2;  //no. of days
        waysToEat(n);
    }
}
/**
 * Inorder to have a burger today, we need to remove the count of burger from yesterday's bread and pizza.
 * dp[0][i-1] + dp[1][i-1] have 2 dp[2][i-2]
 */