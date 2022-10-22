package com.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    static boolean isPartitonPossible( int sum, int nums[]){
        boolean dp[][] = new boolean[nums.length][sum+1];

        dp[0][nums[0]] = true;

        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        for(int idx = 1; idx < nums.length; idx++){
            for(int j=1; j <= sum ; j++){
                boolean notPick = dp[idx-1][j];
                boolean pick = false;
                if(nums[idx] <= j){
                    pick = dp[idx-1][j-nums[idx]];
                }

                dp[idx][j] = pick || notPick;
            }
        }

        return dp[nums.length-1][sum];
    }

    public static boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        if(nums.length == 2) return nums[0] == nums[1];
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;

        boolean res = isPartitonPossible(sum/2, nums);
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {3,3,3,4,5};
        boolean result = canPartition(nums);
        System.out.println(result);

    }

}
