package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Problem Statement: Generate all possible subsets of an array.
     * Hint: Draw the tree to understand the solution
     */
    static List<List<Integer>> subsets = new ArrayList<>();

    static void generateSubsets(int nums[]){
        backtrack(nums, new ArrayList(), 0);
        System.out.println(subsets);
    }

    static void backtrack(int nums[], List<Integer> res, int index){
        if(index == nums.length){
            // if we subsets.add(res); res is [] in the end hence all values are [].
            subsets.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);  //add
        backtrack(nums, res, index+1);
        res.remove(res.size()-1);  //skip
        backtrack(nums, res, index+1);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        generateSubsets(nums);
    }
}
