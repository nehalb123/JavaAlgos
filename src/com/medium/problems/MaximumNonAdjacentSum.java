package com.medium.problems;

/*
Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence
should be adjacent in the array. So [3, 2, 7, 10] should return 13
https://imgur.com/Ue8QJtF
*/
public class MaximumNonAdjacentSum {

    static int maximumNonAdjSum(int arr[]){
        int inc = arr[0];
        int exc = 0;
        int temp;
        for(int i = 1; i < arr.length; i++){
            temp = inc;
            inc = Math.max(temp,exc+arr[i]);
            exc = temp;
        }
        return inc;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{15,5,10,100,10,5};
        int sum = maximumNonAdjSum(arr);
        System.out.println(sum);
    }
}
