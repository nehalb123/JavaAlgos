package com.numbertheory;

public class GCD {
    /**
     * gcd(0,0) = undefined
     * @param a
     * @param b
     * @return
     */
    static int findGCD(int a, int b){
        if(b == 0)
          return a;
        return findGCD(b, a%b);
    }

    public static void main(String[] args) {
        int GCD = findGCD(16, 18);
        System.out.println("GCD is: " +GCD);
    }
}
