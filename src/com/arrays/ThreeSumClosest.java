package com.arrays;

import java.util.Arrays;


public class ThreeSumClosest {

    static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = nums[0]+nums[1]+nums[n-1];
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int curr_sum = nums[i]+nums[left]+nums[right];
                if(curr_sum > target){
                    right--;
                }else{
                    left++;
                }
                if(Math.abs(curr_sum - target) < Math.abs(result - target)){
                    result = curr_sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4};
        int target = 1;
        int res = threeSumClosest(nums, target);
        System.out.println("Closest sum to target is: "+res);

    }
}
