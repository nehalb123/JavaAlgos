package com.dynamicprogramming;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int dp[] = new int[s.length()];
        int max = 0;

        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static int longestValidParenthesesStack(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else{
                   res = Math.max(res , i - stack.peek());
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "(()";
        int len = longestValidParenthesesStack(s);
        int len2 = longestValidParentheses(s);
        System.out.println("Length of longest valid parantheses is: " + len);
    }

}
