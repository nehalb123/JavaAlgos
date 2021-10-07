package com.arrays;

import java.util.HashMap;

/**
 * Finding mode of a number
 * If multiple numbers have the same frequency return the one with least value.
 */
public class FindMode {

    static void findMode(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int minNum = Integer.MAX_VALUE;
        int maxFreq = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num) >= maxFreq && num < minNum){
                maxFreq = map.get(num);
                minNum = num;
            }
        }
        System.out.println("Mode of the number: " + minNum);
    }

    public static void main(String[] args) {
        int nums[] = {3,3,3,2,2,2,1,1,1,4,4,4,0,0,0};
        findMode(nums);
    }
}
