package com.bit;

import java.util.ArrayList;
import java.util.List;

class Subsets {

     static  void generateSubsets(int nums[]){
         List<List<Integer>> subsets = new ArrayList<>();
         int n = nums.length;
         for(int i=(int)Math.pow(2,n);i < (int)Math.pow(2,n+1);i++){
             String bitmask = Integer.toBinaryString(i).substring(1);
             List<Integer> res = new ArrayList<>();
             for(int j = 0;j < bitmask.length();j++){
                  if(bitmask.charAt(j) == '1'){
                      res.add(nums[j]);
                  }
             }
             subsets.add(res);
         }
         System.out.println(subsets);
     }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        generateSubsets(nums);
    }
}

/**
 * 1000
 * 1001
 * 1010
 * 1011
 * 1100
 * 1101
 * 1110
 * 1111
 */