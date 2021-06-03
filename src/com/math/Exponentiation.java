package com.math;

import java.util.Scanner;

/**
 * Your task is to efficiently calculate values a^b
 *
 * Time Complexity: O(log b)
 */
public class Exponentiation {

    static int M = 1000000007;

    static long power(long a, long  b){
        if(b == 0) return 1;
        if(b == 1) return a;
        long res = power(a,b/2);
        long result = (res*res)%M;
        if(b %2 == 1) result = (result*a)%M;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long result = power(a, b);
            System.out.println(result);
        }
    }
}
