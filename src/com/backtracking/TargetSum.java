package com.backtracking;

public class TargetSum {


     static int solve(int index, int nums[], int target, int currSum){
        if(index == nums.length){
            if(currSum == target) {
                return 1;
            }
            return 0;
        }
        int add = solve(index+1, nums, target, currSum+nums[index]);
        int sub = solve(index+1, nums, target, currSum-nums[index]);

        return add+sub;
    }


    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1};
        int target = 3;
        int ways = solve(0, nums, target, 0);
        System.out.println("No. of ways to make target: "+ ways);
    }
}
