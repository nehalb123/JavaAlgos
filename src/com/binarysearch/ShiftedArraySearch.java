package com.binarysearch;

public class ShiftedArraySearch {
/**
 * Problem Statement: Search an element in a sorted but rotated array.
 *
 * Hint: Draw the continuous histogram to visualize where the pivot will be
 *
 * tags: [Binary Search]
 * */
    static int findPivot(int arr[]){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2 ;
            if(mid+1 != arr.length && arr[mid] > arr[mid+1]){ return mid+1;}
            else if(arr[left] > arr[mid]) {right = mid-1;}
            else {left = mid+1;}
        }
        return 0;
    }

    static int shiftedArraySearch(int arr[], int num){
        int pivot = findPivot(arr);
        if(arr[0] > num || pivot == 0)
            //right half
            return binarySearch(arr, pivot,arr.length-1,num);
        //left half
        return binarySearch(arr,0,pivot-1,num);
    }

    static int binarySearch(int arr[], int start, int end, int find){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == find) return mid;
            else if(find > arr[mid] ) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,1};
        int num = 1;
        int pos = shiftedArraySearch(arr, num);
        System.out.println("Found at index: "+pos);
    }
}
