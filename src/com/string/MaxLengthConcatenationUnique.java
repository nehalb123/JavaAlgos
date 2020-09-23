package com.string;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthConcatenationUnique {
    /**
     *  Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
     *  Return the maximum possible length of s
     *
     *  Idea: DFS on the array of strings will give permutations -> filter longest strings with unique characters.
     *  https://imgur.com/m3AmhSC
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
        findPermutations(arr,curr,index+1,lengthTillNow); //skip
        findPermutations(arr,curr+arr.get(index), index+1, lengthTillNow); //select
    }

    /**
     * Efficient solution
     * @param args
     */
    /*
    static int maxLength(List<String> arr) {
        List<Integer> unique = new ArrayList();
        for(String s: arr){
            int binary = toBinary(s);
            if(binary != -1){
                unique.add(binary);
            }
        }
        return combine(unique,0,0);
    }

    static int combine(List<Integer> unique, int i, int res){
        if(i >= unique.size()){
            return Integer.bitCount(res);
        }
        //if combination possible -> combine OR Don't combine and go to next String
        return Math.max(((res & unique.get(i)) == 0) ?
                combine(unique,i+1,res|unique.get(i)) : 0,
                combine(unique,i+1,res));
    }

    static int toBinary(String s){
        int binaryForString = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int setBit = 1 << (s.charAt(i)-'a');
            if((setBit & binaryForString)!=0){ //duplicate character
                return -1;
            }
            binaryForString|=setBit;
        }
        return binaryForString;
    }
    */

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println("Max Length with unique: "+ maxLength(arr));

    }
}
