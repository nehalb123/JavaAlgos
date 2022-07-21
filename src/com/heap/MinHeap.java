package com.heap;

import java.util.Arrays;

public class MinHeap {
    /**
     * Implementation of Heap/Priority Queue:
     *
     * https://imgur.com/LPl4kwi
     * https://imgur.com/lO9uX7i
     *
     * Time analysis to build a heap: https://imgur.com/GvgEXeI
     */
    private int capacity = 10;
    private int size = 0;
    int items[] = new int[capacity];

    /**
     * Helper methods
     */
    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index)<size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index)<size;}
    private boolean hasParent(int index){return getParentIndex(index)>=0;}

    private int leftChild(int index){return items[getLeftChildIndex(index)];}
    private int rightChild(int index){return items[getRightChildIndex(index)];}
    private int parent(int index){return items[getParentIndex(index)];}

    private void swap(int i, int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }

    public int peek(){
        if(size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll(){
        /**
         * Notice we place the last element at the top and heapify it. This is done to avoid any gaps in the heap.
         * Heap does not have any gaps hence we can use array to store the nodes and get parent/child efficiently.
         */
        if(size == 0){
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    /**
     * Iterated insertion
     * @param item
     */
    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){ //if the node has no left child, then there is certainly no right child.
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(10);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.poll();
        for(int i=0; i < minHeap.size; i++){
            System.out.print(minHeap.items[i]+ " ");
        }
    }
}
