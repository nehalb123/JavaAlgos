package com.math;

import java.util.ArrayList;

public class PrimeFactors {

    static void primeFactors(int num){
        int n = num;
        ArrayList<Integer> primeFactors = new ArrayList();
        while(n%2 == 0){
            n/=2;
            primeFactors.add(2);
        }
        for(int i=3;i<=Math.sqrt(n);i+=2){
            while(n%i == 0){
                n/=i;
                primeFactors.add(i);
            }
        }
        if(n > 2){
            primeFactors.add(n);
        }
        System.out.println("Prime factors of " + num + " are: " + primeFactors);
    }

    public static void main(String[] args) {
        primeFactors(25);
    }
}
