package com.sorting;

public class HeapSort {
    /**
     * Time analysis to build a heap: https://imgur.com/GvgEXeI
     */
    static int size = 0;
    static int arr[] = {12, 11, 13, 5, 6, 7};

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int leftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return arr[getRightChildIndex(index)];
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void poll() {
        size--;
        swap(0, size);
    }

    void maxHeapify(int arr[], int index) {  //O(log n)
        while (hasLeftChild(index)) {
            int greaterChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                greaterChildIndex = getRightChildIndex(index);
            }
            if (arr[index] > arr[greaterChildIndex]) {
                return;
            } else {
                swap(index, greaterChildIndex);
            }
            index = greaterChildIndex;
        }
    }

    void heapSort(int arr[]) {
        size = arr.length;
        int nonLeafIndex = size / 2;
        //build heap
        for (int i = nonLeafIndex - 1; i >= 0; i--) {  //O(n)
            maxHeapify(arr, i);
        }
        //extract max -> put in the end of array -> decrement size
        while (size > 1) {  //O(n)
            poll();
            maxHeapify(arr, 0);  //O(log n)
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        obj.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
