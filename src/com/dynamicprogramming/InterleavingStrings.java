package com.dynamicprogramming;


import java.util.HashMap;

/**
 * This program uses top-down approach to DP.
 */
public class InterleavingStrings {

    static HashMap<String, Boolean> map = new HashMap<>();

    static boolean check(String s1, String s2, String s3, int len1, int len2, int len3, int ptr1, int ptr2, int ptr3){
        //length mismatch
        if(len3 != len1+len2){
            return false;
        }
        if(ptr3 == len3){
            return (ptr1 == len1 && ptr2 == len2) ? true : false;
        }
        //memoization
        String key = ptr1 + "*" + ptr2 + "*" + ptr3;
        if(map.containsKey(key)){
            return map.get(key);
        }
        //case 1
        if(ptr1 == len1){
            map.put(key, (s2.charAt(ptr2) == s3.charAt(ptr3) ? check(s1, s2, s3, len1, len2, len3, ptr1, ptr2+1, ptr3+1) : false));
            return map.get(key);
        }
        //case 2
        if(ptr2 == len2){
            map.put(key, (s1.charAt(ptr1) == s3.charAt(ptr3) ? check(s1, s2, s3, len1, len2, len3, ptr1+1, ptr2, ptr3+1) : false));
            return map.get(key);
        }
        boolean pathOne = false, pathTwo = false;
        if(s1.charAt(ptr1) == s3.charAt(ptr3)){
            pathOne = check(s1,s2,s3,len1,len2,len3,ptr1+1,ptr2,ptr3+1);
        }
        if(s2.charAt(ptr2) == s3.charAt(ptr3)){
            pathTwo = check(s1,s2,s3,len1,len2,len3,ptr1,ptr2+1,ptr3+1);
        }
        map.put(key, pathOne || pathTwo);
        return map.get(key);


    }


    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aabbcbcacd";
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean result = check(s1, s2, s3, len1, len2, len3, 0, 0, 0);
        System.out.println("Is s3 interleaving? "+result);
    }
}
