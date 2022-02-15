package com.string;

public class MinRemovalsToMakeValidParentheses {
    /**
     *  1. Maintain count of open brackets
     *  2. Iterate over the string from left to right, remove extra closing brackets
     *  3. Iterate over the string from right to left, remove remaining opening brackets.(Here we iterate from right to
     *  left because removing opening brackets from left would make the string imbalanced)
     *  4. Reverse the string and return.
     *
     */
    static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                open++;
            } else if(ch == ')'){
                if(open == 0) continue;
                open--;
            }
            sb.append(ch);
        }
        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i >=0 ; i--){
            if(sb.charAt(i) == '(' && open-- > 0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
