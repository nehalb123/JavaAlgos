package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://imgur.com/SYPdPob
 */
public class GeneratePermutations {

    static void backtrack(int nums[], List<List<Integer>> res, List<Integer> curr, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i < nums.length; i++){
            if(visited[i] == true) continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, res, curr, visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }

    static void permute(int nums[]){
        boolean visited[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList(), visited);
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute(nums);
    }
}
