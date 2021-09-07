package com.sorting;

public class MergeSort {
    /**
     * https://imgur.com/QoWe9mI
     * */
    static void merge(int left[], int right[], int arr[]) {
        int l = left.length;
        int r = right.length;
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
            k++;
        }
        while (i < l) {
            arr[k] = left[i++];
            k++;
        }
        while (j < r) {
            arr[k] = right[j++];
            k++;
        }
    }

    static void mergeSort(int arr[]) {
        int len = arr.length;
        if (len < 2)
            return;
        int mid = len / 2;
        int left[] = new int[mid];
        int right[] = new int[len - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < len; j++) {
            right[j - mid] = arr[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{2, 4, 1, 1, 6, 8, 5, 3, 7};
        mergeSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
