package com.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 *
 * README: Available in the folder
 */
public class NextGreaterElement {

    static int[] findNextGreatestElement(int arr[]){
        int n = arr.length;
        int output[] = new int[n];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i%n]){
                output[stack.pop()] = arr[i%n];
            }
            if(i < n) stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int res[] = findNextGreatestElement(arr);
        Arrays.stream(res).forEach(item -> System.out.print(item + " "));
    }
}

