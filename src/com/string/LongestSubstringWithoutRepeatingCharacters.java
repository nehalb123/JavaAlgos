package com.string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Visual aid: https://imgur.com/BqU3Ema
     *
     * @param s
     * @return
     */

    static int longestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(right - left, max);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abrcexabrz";
        System.out.println(longestSubstring(s));
    }
}
