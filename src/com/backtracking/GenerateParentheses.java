package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /**
     * Classic backtracking example.
     * Constraints are hard to get.
     * We need to interpret the meanings of constraints. First, the first character should be “(“.
     * Second, at each step, you can either print “(“ or “)”, but print “)” only when there are more “(“s than “)”s.
     * Stop printing out “(“ when the number of “(“ s hit n.
     */
    static void generateParentheses(int n){
        List<String> list = new ArrayList<>();
        backtrack(list,"", 0, 0,n);
    }

    static void backtrack(List<String> list, String str, int open, int closed, int n){
        if(str.length() == 2*n){
            list.add(str);
            System.out.println(str);
            return;
        }
        if(open < n) {
            backtrack(list, str + "(", open+1, closed, n);
        }
        if(closed < open) {
            backtrack(list, str + ")", open, closed+1, n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(n);
    }
}


/**
 * Printing all combinations:
 * The goal is to print a string of “(“ ,”)” in certain order. The length of string is 2n. The constraints are that “(“s
 * need to match “)”s. Without constraints, we just simply print out “(“ or “)” until length hits n. So the base case
 * will be length ==2 n, recursive case is print out “(“ and “)”. The code will look like
 *
 * //base case
 * if(string length == 2*n) {
 * add(string);
 * return;
 * }
 * //recursive case
 * add a “(“
 * add a “)"
 */