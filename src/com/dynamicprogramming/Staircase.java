package com.dynamicprogramming;

public class Staircase {
    /**
     * Variation of climb staircase problem where step size can be any number from set X
     * Problem Statement: Count the number of ways to reach the top of the N staircases.
     *
     * https://imgur.com/ZelAzMn
     *
    */

    static int climbStairs(int X[], int total){
        if(total == 0) return 1;
        int ways[] = new int[total+1];
        ways[0] = 1;
        int sum;
        for(int i=1;i<=total;i++){
            sum = 0;
            for(int j:X) {
                if(i-j>=0) {
                    sum += ways[i-j];
                }
            }
            ways[i] = sum;
        }
        return ways[total];
    }

    public static void main(String[] args) {
        int totalStairs = 5;
        int X[] = {1,2,3};
        int waysToReachTop = climbStairs(X, totalStairs);
        System.out.println("Ways to reach the top: "+waysToReachTop);
    }
}
