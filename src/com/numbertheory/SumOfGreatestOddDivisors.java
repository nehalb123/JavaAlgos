package com.numbertheory;

import java.util.Scanner;

public class SumOfGreatestOddDivisors {
    /*You are given a positive integer N. f(N) is the greatest odd divisor of N. Find the sum (f(1)+f(2)+..f(N)).
    *https://imgur.com/kJTbfpG
    *  */
    static long square(long n) {
        return (n*n);
    }

    static long sum(long n){
        if (n == 0)
            return 0;
        if (n % 2 == 1) {
            return (square((n + 1)/2) + sum((n/2)));
        } else{
            return (square(n/2) + sum((n/2)));
        }
    }

    static long findSumOfDivs(long n){
        return sum(n);
    }

    public static void main(String args[] ) {
        Scanner s = new Scanner(System.in);
        int testcases = s.nextInt();
        while(testcases-- > 0){
            long n = s.nextLong();
            long sum = findSumOfDivs(n);
            System.out.println(sum);
        }

    }
}
