package com.string;

import java.util.HashMap;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty
 * string "".
 */
public class MinimumWindowSubstring {

    static String minWindow(String s, String t){
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        //create a map for string t
        for(char ch: t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }
        int have = 0;
        int need = tMap.size();

        int res[] = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        for(; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);

            if(tMap.containsKey(ch) && window.get(ch) == tMap.get(ch)){
                have++;
            }
            //shrink the window
            while(have == need){
                if(right-left+1 < resLen){
                    res[0] = left;
                    res[1] = right;
                    resLen = right-left+1;
                }
                //update window
                window.put(s.charAt(left), window.get(s.charAt(left))-1);

                if(tMap.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < tMap.get(s.charAt(left)) ){
                    have--;
                }
                left++;
            }
        }
        left = res[0];
        right = res[1];

        return (resLen != Integer.MAX_VALUE) ? s.substring(left, right+1) : "";
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t= "ABC";

        String result = minWindow(s, t);
        System.out.println(result);
    }
}
