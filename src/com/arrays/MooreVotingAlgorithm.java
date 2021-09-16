package com.arrays;

public class MooreVotingAlgorithm {
    /**
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * Approach 1:
     * 1. Find median by sorting the array
     *
     * Approach 2:
     * 1. Use Moore's voting algorithm.
     */
    static int majorityElement(int arr[]){
        int ptr = 0;
        int count = 1;
        /*
        Find the candidate
        */
        for(int i=1;i<arr.length;i++){
            if(arr[ptr]==arr[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){  //update number when count reaches zero
                ptr = i;
                count = 1;
            }
        }
        /*
        Check if it is majority element
        */
        int candidate = arr[ptr];
        int countOfCandidate = 0;
        for(int i=0;i<arr.length;i++){
            if(candidate == arr[i]){
                countOfCandidate++;
            }
        }
        if(countOfCandidate < arr.length/2){
            System.out.println("No majority element");
            return -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,3,7,3};
        int majorityElement = majorityElement(arr);
        System.out.println("Majority Element: "+majorityElement);
    }
}
