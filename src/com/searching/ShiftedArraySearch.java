package com.searching;

public class ShiftedArraySearch {
/*Hint: Draw the continuous histogram to visualize where the pivot will be*/
    static int findPivot(int arr[]){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left <= right){
            mid = left + (right-left)/2;
            if(mid == 0 || arr[mid]<arr[mid-1]){
                return mid;
            }else if(arr[0] < arr[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return 0;
    }

    static int shiftedArraySearch(int arr[], int num){
        int pivot = findPivot(arr);
        if(arr[0] > num || pivot == 0)
            return binarySearch(arr,pivot,arr.length-1,num);
        return binarySearch(arr,0,pivot-1,num);
    }

    static int binarySearch(int arr[], int start, int end, int find){
        int mid;
        while(start <= end){
            mid = start+(end-start)/2;
            if(find < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
            if(arr[mid]==find){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{9,12,17,2,4,5};
        int num = 12;
        int pos = shiftedArraySearch(arr, num);
        System.out.println("Found at index: "+pos);
    }
}
