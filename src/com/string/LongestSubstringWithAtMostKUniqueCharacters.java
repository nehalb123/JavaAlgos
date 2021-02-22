package com.string;

import java.util.HashMap;

public class LongestSubstringWithAtMostKUniqueCharacters {

    static int longestSubstringWithAtMostKUnique(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (right < s.length()) {
                flag1 = true;
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                if (!(map.size() > k)) {
                    max = Math.max(right - left, max);
                } else {
                    break;
                }
            }
            while (left < right) {
                flag2 = true;
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
                if (map.size() > k) {
                    continue;
                } else {
                    break;
                }
            }
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String example = "ddacbbaccdedacebb";
        System.out.println(longestSubstringWithAtMostKUnique(example, 3));
    }

}
