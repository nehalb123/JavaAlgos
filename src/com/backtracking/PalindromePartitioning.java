package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * https://imgur.com/a/21hHNGg
 */
public class PalindromePartitioning {

    static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> partition = new ArrayList();
        backtrack(s, 0 , result, partition);

        return result;
    }

    static void backtrack(String s, int index, List<List<String>> result, List<String> partition){
        if(index == s.length()){
            result.add(new ArrayList(partition));
            return;
        }
        for(int i=index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                partition.add(s.substring(index, i+1));
                backtrack(s, i+1, result, partition);
                partition.remove(partition.size()-1);
            }
        }
    }


    static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }

}
