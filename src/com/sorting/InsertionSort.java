package com.sorting;

public class InsertionSort {

    static int[] insertionSort(int[] arr){
        /*Hint: Consider you are sorting a deck of cards*/
        for(int i = 0; i < arr.length; i++){
            int j = i;
            while(j > 0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }


        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,8,5,-9,4};
        int sortedArray[] = insertionSort(arr);
        for(int i = 0; i < arr.length ; i++) {
            System.out.print(sortedArray[i]+" ");
        }
    }
}
