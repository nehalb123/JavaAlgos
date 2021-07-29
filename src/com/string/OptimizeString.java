package com.string;

import java.util.HashSet;

public class OptimizeString {
    /**
     * Goldman Sachs
     * The question states optimize input in such a way that repeating pattern is replaced with "*"
     * Example :
     * input - "ABABCABABCD"
     * output - "AB*C*D"
     * Explanation -
     * Here, till "AB*" of the output, "AB" repeats twice, but till "ABC" , "ABABC" repeats twice in the input string
     */
    static void optimizeString(String input){
        HashSet<Character> set = new HashSet<>();
        String str = "";
        for(int i=0; i<input.length();){
            char ch = input.charAt(i);
            if(!set.contains(ch)){
                //not contains -> add
                set.add(ch);
                str+=ch;
                i++;
                continue;
            }
            //skip which contains
            while(i < input.length()-1 && set.contains(ch)){
                ch = input.charAt(++i);
            }
            str+="*";

        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        String input = "ABABCABABCD";
        optimizeString(input);
    }
}
