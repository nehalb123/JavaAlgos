package com.dynamicprogramming;

import java.util.Arrays;

/**
 * This program demonstrates top-down approach in DP which is recursive+memoization.
 * Sequence: 1 1 2 3 5 8 13 21 ...
 */
public class FibTopDown {

    static int fib(int n, int[] memo){
        if(n <= 2){
            return 1;
        }else if(memo[n] != -1){
            return memo[n];
        } else{
            memo[n] = fib(n-1, memo) + fib(n-2, memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        int result = fib(n, memo);
        System.out.println(n + "th fibonacci number is: "+result);
    }
}
