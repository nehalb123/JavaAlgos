package com.arrays;

/**
 * Rating ⭐ ⭐ ⭐ ⭐
 * Given an array of integers, find the maximum possible sum you can get from one
 * of it's contiguous sub-arrays.
 * i.e. Max Subarray Sum
 */
public class KadaneAlgorithm {

    /**
     * For the ith index, we store current sum, not necessarily the max sum.
     * if this current sum goes negative, we keep the previous sum.
     * if current sum was already negative, we compare the sum with the element to choose and the sum till now.
     * Once we get this, we can replace the array with two variables.
     */
    public int maxSubArray(int[] nums) {
        int maxSubArraySumTillNow[] = new int[nums.length];
        int maxSum = nums[0];
        maxSubArraySumTillNow[0] = nums[0];
        for(int i=1; i < nums.length; i++){

            maxSubArraySumTillNow[i] = Math.max(nums[i], maxSubArraySumTillNow[i-1] + nums[i]);
            maxSum = Math.max(maxSum, maxSubArraySumTillNow[i]);

        }
        return maxSum;
    }

    static int maxSubArraySum(int[] arr){
        int len = arr.length;
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            curr_sum += arr[i];
            curr_sum = Math.max(curr_sum, arr[i]); //choose only the current element or the curr_sum?
            max_sum = Math.max(curr_sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,-2,-3};
        int maxSum = maxSubArraySum(arr);
        System.out.println(maxSum);
    }
}
