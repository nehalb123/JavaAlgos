package com.string;

import java.util.Stack;

public class ValidParentheses {

    static boolean isValidParenthesis(String s){
        Stack<Character> stack = new Stack();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(ch == '['){
                stack.push(']');
            }else if(ch == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != ch){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String brackets = "()())()";
        boolean isBalanced = isValidParenthesis(brackets);
        System.out.println(isBalanced);
    }
}
