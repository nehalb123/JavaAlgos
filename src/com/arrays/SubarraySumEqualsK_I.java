package com.arrays;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals
 * to k.
 *
 * tags: [Arrays, Prefix Sum, HashMap]
 */
public class SubarraySumEqualsK_I {

    static int subarraySum(int nums[], int k){
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);

        for(int i=0; i < nums.length; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum-k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }


    public static void main(String[] args) {
        int nums[] = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int count = subarraySum(nums, k);
        System.out.println("No. of subarrays with sum "+k+" : "+count);
    }
}
