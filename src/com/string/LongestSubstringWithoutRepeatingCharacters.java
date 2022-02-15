package com.string;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Approach 1: Brute force
 * 1. Generate all substrings.
 * 2. For each substring, check if a character is repeated.
 *
 *  Approach 2: Sliding window. similar to `Minimum Window substring`
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Visual aid: https://imgur.com/BqU3Ema
     */

    static int longestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                //unique character
                set.add(s.charAt(right));
                right++;
                max = Math.max(right - left, max);
            } else {
                //duplicate character encountered
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
