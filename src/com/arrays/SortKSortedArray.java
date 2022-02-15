package com.arrays;

/**
 * Given an array of n elements, where each element is at most k away from its target position, devise an algorithm
 * that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can
 * be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * Approach 1: As the array is partially sorted, apply insertion sort. Time Complexity: O(Nk).
 * Good when k is small.
 *
 * Approach 2: Use min heap of size k+1, extract min.
 *             Time Complexity: O(k) + O((n-k) * (log k)) = O(n * log k)
 */
public class SortKSortedArray {


    public static void main(String[] args) {

    }
}
