package com.arrays;

/**
 * Rating ⭐ ⭐
 *
 * Difficulty: Easy
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
 * of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as
 * nums.
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 * Approach: Store in a map
 *
 * 1. Store <Integer, List> in a map, where value of map store all the indexes of current num
 * 2. the size of list appears to be the frequency.
 *    and the list.get(list.size()-1) - list.get(0) appear to be the length
 */
public class DegreeOfArray {
    public static void main(String[] args) {

    }
}
