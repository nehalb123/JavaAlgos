package com.hackercup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Alchemy {
    /**
     * https://www.facebook.com/codingcompetitions/hacker-cup/2020/qualification-round/problems/B
     * */
    static HashMap<String, String> reduced = new HashMap<>();

    static String isCombiningPossible(String s) {
        int left = 0;
        int right = 2;
        while (right < s.length() - 1) {
            String shard = s.substring(left, right+1);
            if (reduced.containsKey(shard)) {
                s = s.substring(0, left) + reduced.get(shard) + s.substring(right + 1);
                left = 0;
                right = 2;
            } else {
                left++;
                right++;
            }
        }
        if (reduced.containsKey(s)) {
            return "Y";
        } else {
            return "N";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int count = 1;
        reduced.put("AAB","A");
        reduced.put("ABA","A");
        reduced.put("BAA","A");
        reduced.put("ABB","B");
        reduced.put("BAB","B");
        reduced.put("BBA","B");
        while(testcases-- > 0){
            int len = sc.nextInt();
            String s = sc.next();
            System.out.print("Case #"+count+++":");
            System.out.println(" "+isCombiningPossible(s));
        }
    }
}
