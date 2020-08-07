package com.medium.problems;

import java.util.Scanner;

/**
You are given two numbers n and k. For each number in the interval [1, n],
your task is to calculate its largest divisor that is not divisible by k.
Print the sum of these divisors.
Note: k is a prime number.
Explanation

n=10 k=3 In the first test case, f (x) from 1 to 10 is [1, 2, 1, 4, 5, 2, 7, 8, 1, 10], sum of which is 41.
n=10 k=2 In the second test case, f (x) from 1 to 10 is [1, 1, 3, 1, 5, 3, 7, 1, 9, 5].
 */

public class NumberOfDivisors {

        static long arithmeticProgression(long n){
            return n*(n+1)/2;
        }

        static long sumOfLargestDivs(int n, int k){
            long answer = arithmeticProgression(n);
            int factor = n/k;
            while(factor > 0){   //10 -> 10/3 -> 3/3
                answer-= (k-1)*arithmeticProgression(factor);
                factor/=k;
            }
            return answer;
        }

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int testcases = s.nextInt();
            while(testcases-- > 0){
                int n = s.nextInt();
                int k = s.nextInt();
                long answer = sumOfLargestDivs(n,k);
                System.out.println(answer);
            }
        }

}
