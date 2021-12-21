package com.arrays;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence
 * should be adjacent in the array. So [3, 2, 7, 10] should return 13
 * Note 🔴 : This is House Robber question.
 * https://imgur.com/WJO6kwJ
 *
 * Rating: ⭐ ⭐ ⭐ ⭐ ⭐
 */
public class MaximumNonAdjacentSum {

    static int maximumNonAdjSum(int arr[]){
        int inc = arr[0];
        int exc = 0;
        int temp;
        for(int i = 1; i < arr.length; i++){
            temp = inc;
            inc = exc + arr[i];
            exc = Math.max(temp, exc);
        }
        return Math.max(inc, exc);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 7, 10};
        int sum = maximumNonAdjSum(arr);
        System.out.println(sum);
    }
}
