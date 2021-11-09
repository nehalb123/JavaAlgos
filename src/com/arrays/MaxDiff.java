package com.arrays;

public class MaxDiff {
    /**
     *  Given an array arr[] of integers,
     *  find out the maximum difference between any two elements such that larger element appears after the smaller number.
     * */
    static int calculateMaxDiff(int arr[]){
        int maxDiff = arr[1]-arr[0];
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-min > maxDiff){
                maxDiff = arr[i]-min;
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {7, 9, 5, 6, 3, 2};
        int maxDiff = calculateMaxDiff(arr);
        System.out.println("Max Diff: "+maxDiff);
    }
}
