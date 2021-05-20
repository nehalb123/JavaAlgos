package com.arrays;

public class KadaneAlgorithm {
    /**
     * Rating ⭐ ⭐ ⭐ ⭐
     * Given an array of integers, find the maximum possible sum you can get from one
     * of it's contiguous sub-arrays.
     */

    static int maxSubArraySum(int[] arr){
        int len = arr.length;
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            curr_sum += arr[i];
            curr_sum = Math.max(curr_sum, arr[i]);
            max_sum = Math.max(curr_sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,6,-3,7};
        int maxSum = maxSubArraySum(arr);
        System.out.println(maxSum);
    }
}
