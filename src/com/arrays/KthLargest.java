package com.arrays;


import java.util.Random;

/**
 * Problem Statement: Find the kth largest/smallest element of an array.
 *
 * QuickSelect was giving me 16ms runtime on LC.
 * Randomizing the array resulted in 2ms runtime.
 *
 * https://imgur.com/a/Bf0o539
 *
 * Approach:
 * 1.   Store in a min-heap -> O(k) + O((n-k) * log k) = O(n log k)
 *
 * 2.   QuickSelect
 *
 * Time Complexity: O(n) avg case
 *
 * Worst case: O(n^2)
 */
public class KthLargest {

    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int pIndex = start;
        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                swap(arr,i,pIndex);
                pIndex++;
            }
            //pIndex points to a number larger than pivot
        }
        swap(arr,pIndex,end);
        return pIndex;
    }

    private static void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = a.length/2; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    static void kthLargest(int arr[], int k){
        shuffle(arr);
        k = arr.length - k;   //kth largest = n-k smallest
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            int pIndex = partition(arr, start, end);
            if(pIndex > k){
                end = pIndex-1;
            }else if(pIndex < k){
                start = pIndex+1;
            }else{
                break;
            }
        }

        System.out.println("Kth largest element is: "+ arr[k]);
    }

    public static void main(String[] args) {
        int k = 2;
        int arr[] = new int[]{3,2,1,5,6,4};
        kthLargest(arr, k);
    }
}
