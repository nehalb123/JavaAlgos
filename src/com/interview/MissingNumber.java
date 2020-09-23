package com.interview;

public class MissingNumber {
    /**
    *  Idea: The difference of the index and number will be 2 after the missing number.
    * */
    static int findMissing(int arr[]){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left <= right){
            mid = left + (right-left)/2; //avoid overflows
            if(mid > 0 && arr[mid-1]-(mid-1) == 1 && arr[mid]-(mid)==2){
                return arr[mid]-1;
            }else if(mid > 0 && arr[mid-1]-(mid-1) == 1 ){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return arr[0]-1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 8};
        System.out.println(findMissing(arr));
    }
}
