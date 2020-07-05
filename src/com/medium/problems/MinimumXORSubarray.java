package com.medium.problems;

public class MinimumXORSubarray {
    /*
    Given an array arr[] and integer K, the task is to find the minimum bitwise XOR sum of any subarray of size K in the given array.
    Naive Approach: O(n*k)
    Best approach: Sliding window; finds minimum XOR subarray in a single pass.
    */
    static int[] minimumXORSubarray(int arr[],int k){
        int curr_xor = 0;
        int min_xor;
        int left=0;
        int right=k-1;
        for (int i=0; i < k; i++){
            curr_xor^=arr[i];
        }
        min_xor = curr_xor;
        for(int i = k; i < arr.length; i++){
            curr_xor^=(arr[i]^arr[i-k]);
            if(curr_xor < min_xor){
                min_xor = curr_xor;
                left = i-k+1;
                right=i;
            }
        }
        System.out.println("Minimum XOR of subarray with size "+k+": "+min_xor);
        return new int[]{left,right};

    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 7, 5, 20, -10, 0, 12};
        int k = 2;
        int minXOR[] = minimumXORSubarray(arr,k);
        System.out.println("The subarray with min. XOR is from: "+minXOR[0]+" to "+minXOR[1]);
    }
}
