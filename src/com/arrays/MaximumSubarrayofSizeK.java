package com.arrays;

/**
 * Find the subarray with size k which has the maximum sum
 */
public class MaximumSubarrayofSizeK {

    public static int maximumSumSubarray(int k, int nums[]){
        int maxSum = 0;

        for(int i=0; i < k; i++){
            maxSum +=nums[i];
        }
        int currSum = maxSum;
        for(int i=k; i < nums.length; i++){
            //slide the window
            currSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int k = 4;
        int nums[] = {1, 4, 2, -10, 23, 3, 1, 0, 20};
        int result = maximumSumSubarray(k, nums);
        System.out.println(result);
    }
}
