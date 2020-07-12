package com.sorting;

public class QuickSort {
/*
* https://imgur.com/NxTZkqJ
* */
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
        }
        swap(arr,pIndex,end);
        return pIndex;
    }

    static void quickSort(int arr[],int start,int end){
        if(start<end) {
            int pIndex = partition(arr,start,end);
            quickSort(arr,start,pIndex-1);
            quickSort(arr,pIndex+1,end);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7,2,1,6,8,5,3,4};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
