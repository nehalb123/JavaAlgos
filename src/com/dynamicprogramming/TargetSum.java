package com.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Refer to pure backtracking solution. TargetSum, Backtracking.md
 *
 * This solution is a memoized version of backtracking/TargetSum
 */
public class TargetSum {


    static int solve(int index, int nums[], int target, int currSum, Map<String, Integer> map){
        String encodedString = index + "->" + currSum;
        if(map.containsKey(encodedString)){
            return map.get(encodedString);
        }
        if(index == nums.length){
            if(currSum == target) {
                return 1;
            }
            return 0;
        }
        int add = solve(index+1, nums, target, currSum+nums[index], map);
        int sub = solve(index+1, nums, target, currSum-nums[index], map);
        map.put(encodedString, add+sub);
        return add+sub;

    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1};
        int target = 3;
        int ways = solve(0, nums, target, 0, new HashMap<>());
        System.out.println("No. of ways to make target: "+ ways);
    }
}
