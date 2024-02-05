package com.arrays;

import java.util.Arrays;

/**
 * Right Rotate an array by 'k' steps. This code has a .md file
 */
public class RotateArraybyKSteps {

    static void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int p = k%len;

        reverse(nums, 0, len-1);
        reverse(nums, 0, p-1);
        reverse(nums, p, len-1);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        rotate(nums, 10);
        Arrays.stream(nums).forEach(item -> System.out.print(item + " "));
    }
}
