package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Diagram: https://imgur.com/cn7XLID
 *
 * Read LC Solution
 */
public class TopKFrequentElements {

    static int[] unique;
    static Map<Integer, Integer> count;

    static void swap(int i,int j){
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }

    static int partition(int start, int end){
        int pivot = count.get(unique[end]); //freq of end
        int pIndex = start;
        for(int i=start;i < end;i++){
            if(count.get(unique[i])<=pivot){
                swap(i,pIndex);
                pIndex++;
            }
            //pIndex points to a number larger than pivot
        }
        swap(pIndex,end);
        return pIndex;
    }

    public static void quickSelect(int left, int right, int k_smallest) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

        // base case: the list contains only one element
        if (left == right) return;


        // find the pivot position in a sorted list
        int pivot_index = partition(left, right);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickSelect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        count = new HashMap();
        for(int num: nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        int n = count.size();
        unique = new int[n];
        int j = 0;
        for(int num: count.keySet()){
            unique[j] = num;
            j++;
        }

        quickSelect(0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n-k, n);
    }

    public static void main(String[] args) {
        int arr[] = {4,5,5,2,1,1,1,5,2,3,3,5,2};
        int k = 3;
        int topk[] = topKFrequent(arr, k);
        System.out.println("Top K frequent elements are: ");
        Arrays.stream(topk).forEach(elem ->  System.out.print(elem + " "));
    }
}
