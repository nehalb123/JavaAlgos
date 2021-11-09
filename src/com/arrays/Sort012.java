package com.arrays;

import java.util.Arrays;

/**
 * Approach: Take three pointers, left, mid and right.
 * mid pointer takes the decision when to swap with left or right pointer.
 */
public class Sort012 {

    static void swap(int l, int r, int nums[]){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    static void sortColors(int nums[]){
        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while(mid <= right){
            if(nums[mid] == 0){
                swap(left, mid, nums);
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(right, mid, nums);
                right--;
            }
        }

        Arrays.stream(nums).forEach(item -> System.out.print(item + " "));
    }

    public static void main(String[] args) {
        int nums[] = {1,0,2};
        sortColors(nums);
    }
}
