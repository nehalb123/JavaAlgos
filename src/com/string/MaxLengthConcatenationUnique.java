package com.string;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthConcatenationUnique {
    /**
     *  Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
     *  Return the maximum possible length of s
     * */
    static int checkUnique(String s){
        int alphabet[] = new int[26];
        for(char ch: s.toCharArray()){
            if(alphabet[ch-'a'] >= 1){
                return -1;
            }
            alphabet[ch-'a']++;
        }
        return s.length();
    }

    static int maxLength(List<String> arr){
        int max[] = new int[1];
        findPermutations(arr,"", 0, max);
        return max[0];
    }

    static void findPermutations(List<String> arr, String curr, int index, int lengthTillNow[]){
        if(arr.size()==index && checkUnique(curr) > lengthTillNow[0]){
            lengthTillNow[0] = curr.length();
            return;
        }
        if(arr.size() == index){
            return;
        }
        findPermutations(arr,curr,index+1,lengthTillNow);
        findPermutations(arr,curr+arr.get(index), index+1, lengthTillNow);
    }


    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println("Max Length with unique: "+ maxLength(arr));

    }
}
