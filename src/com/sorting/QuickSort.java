package com.sorting;

public class QuickSort {
/**
* https://imgur.com/NxTZkqJ
* Time Complexity: https://imgur.com/pAluGQW
* */
    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int start, int end){
        /**
         *  If the array is already sorted, the partitioning is unbalanced. This will lead to O(n^2) time complexity.
         *  Hence a random partitioning is helpful in such a case.
         */
        int pivot = arr[end];
        int pIndex = start;
        for(int i=start;i<end;i++){
            //swap a smaller number than pivot with element greater than pivot on pIndex position
            if(arr[i]<=pivot){
                swap(arr,i,pIndex);
                pIndex++;
            }
            //pIndex points to the larger element
        }
        swap(arr,pIndex,end);
        return pIndex;
    }

    static void quickSort(int arr[],int start,int end){
        //sorting happens by partition: When there are two elements left, the array is sorted.
        if(start<end) {
            int pIndex = partition(arr,start,end);
            quickSort(arr,start,pIndex-1);  //left half
            quickSort(arr,pIndex+1,end);  //right half
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
