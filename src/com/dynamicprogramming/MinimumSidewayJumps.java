package com.dynamicprogramming;

/**
 * https://leetcode.com/problems/minimum-sideway-jumps/
 */
public class MinimumSidewayJumps {

    static int min(int... vals){
        int min = Integer.MAX_VALUE;
        for(int val: vals){
            if(val>=0) min = Math.min(min, val);
        }
        return min;
    }

    static int minSideJumps(int[] obstacles) {
        int dp[] = new int[]{1,0,1};
        for(int i=1; i < obstacles.length; i++){
            System.out.println(dp[0] + " " + dp[1] + " " + dp[2]);
            switch(obstacles[i]){
                case 0 :
                    dp[0] = min(dp[0], dp[1]+1, dp[2]+1);
                    dp[1] = min(dp[0]+1, dp[1], dp[2]+1);
                    dp[2] = min(dp[0]+1, dp[1]+1, dp[2]);
                    break;
                case 1:
                    dp[0] = Integer.MAX_VALUE;
                    dp[1] = min(dp[1], dp[2]+1);
                    dp[2] = min(dp[2], dp[1]+1);
                    break;
                case 2:
                    dp[0] = min(dp[0], dp[2]+1);
                    dp[1] = Integer.MAX_VALUE;
                    dp[2] = min(dp[2], dp[0]+1);
                    break;
                case 3:
                    dp[0] = min(dp[0], dp[1]+1);
                    dp[1] = min(dp[1], dp[0]+1);
                    dp[2] = Integer.MAX_VALUE;
                    break;

            }
        }
        return min(dp[0],dp[1], dp[2]);
    }

    public static void main(String[] args) {
        int obstacles[] = {0,1,2,3,0};
        int minJumps =  minSideJumps(obstacles);
        System.out.println("Minimum jumps required: " + minJumps);

    }
}
