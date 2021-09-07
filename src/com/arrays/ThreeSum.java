package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Find triplets such that a+b+c = 0.
 *  1. Sort the array - makes two pointers approach easy.
 *  2. Find pairs such that b+c = (-a)
 *  3. Avoid duplicates
 *
 *  TODO: Diagram?
 */
public class ThreeSum {

    static List<List<Integer>> threeSum(int nums[]){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i < n-2; i++){
            //Avoid duplicates
            if(i == 0 || i > 0 && (nums[i] != nums[i-1])){
                int left = i+1;
                int right = n-1;
                int sum = 0-nums[i];
                while(left < right){
                    if(nums[left] + nums[right] == sum){
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] > sum){
                        right--;
                    }else{
                        left++;
                    }
                }
            }

        }
        return output;
    }

    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
