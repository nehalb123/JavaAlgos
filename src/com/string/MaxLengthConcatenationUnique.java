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
     *
     *  Runtime: O(2^n)
     *  Space: O(n) n stack frames deep in recursion
     * */
    /*static int checkUnique(String s){
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
        if(arr.size()==index && checkUnique(curr) > lengthTillNow[0]){   //if leaf node and valid solution
            lengthTillNow[0] = curr.length();
            return;
        }
        if(arr.size() == index){  //if leaf node
            return;
        }
        findPermutations(arr,curr,index+1,lengthTillNow); //skip
        findPermutations(arr,curr+arr.get(index), index+1, lengthTillNow); //select  NOTE: use StringBuffer instead of String
    }*/

    /**
     * Efficient solution
     * @param arr
     */

    /*static int maxLength(List<String> arr) {
        List<Integer> unique = new ArrayList();
        for(String s: arr){
            int binary = toBinary(s);
            if(binary != -1){
                unique.add(binary); //add string with unique chars to the list
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
    }*/

    /**
     * a -> has encoded binary of the string
     * dp -> has concatenated encodings
     * @param arr
     * @return
     */
    public static int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {  //iterate over the string to check dup. chars
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0)    continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;  //check if strings have unique characters
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println("Max Length with unique: "+ maxLength(arr));

    }
}
