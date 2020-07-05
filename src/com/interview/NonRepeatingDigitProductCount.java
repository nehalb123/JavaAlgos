package com.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
Given a range of numbers [l, r] and an integer q. The task is to count all such number in the given range such that any digit of the
number does not match with any digit in its product with the given number q.

        Example 1:

        Input: l = 10, r = 12, q = 2
        Output: 1
        Explanation:
        10*2 = 20 which has 0 as same digit
        12*2 = 24 which as 2 as same digit
        11*2 = 22 no same digit
*/
public class NonRepeatingDigitProductCount {
    static boolean checkDigits(int q, int i){
        int product = q*i;
        Set<Integer> set1 = digits(i);
        Set<Integer> set2 = digits(product);
        for(Integer it : set1){
            if(set2.contains(it)){
                return false;
            }
        }
        return true;
    }

    static Set<Integer> digits(int n){
        Set<Integer> store = new HashSet<>();
        if(n==0){
            store.add(n);
        }
        while(n>0){
            int num = n%10;
            store.add(num);
            n/=10;
        }
        return store;
    }

    static int nonRepeatingDigitProductCount(int q, int l, int r){
        int count=0;
        for(int i = l; i <= r; i++){
            if(checkDigits(q,i)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int validProducts = nonRepeatingDigitProductCount(q,l,r);
        System.out.println("No. of valid products are: "+ validProducts);
    }
}
