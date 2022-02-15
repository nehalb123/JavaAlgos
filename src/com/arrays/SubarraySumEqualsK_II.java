package com.arrays;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the minimum size of continuous no-empty subarrays
 * whose sum equals to k, and return its length.
 *
 * tags: [Arrays, Prefix Sum, HashMap]
 */
public class SubarraySumEqualsK_II {

    static int subarraySum(int nums[], int k){
        int prefixSum = 0;
        int len = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i < nums.length; i++){
            prefixSum += nums[i];

            int temp = prefixSum-k;
            if(map.containsKey(temp)){
                int index = map.get(temp)+1;
                len = Math.min(len, i-index+1);
            }

            map.put(prefixSum, i);
        }
        if(len == Integer.MAX_VALUE){
            return -1;
        }
        return len;
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int size = subarraySum(nums, k);
        System.out.println("Least subarray size with sum "+k+" : "+size);

    }
}
