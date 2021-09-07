package com.bit;

/**
 * Sum of two integers without using +/-
 */
public class SumTwoIntegers {

    static int addNumbers(int a, int b){
        if(b == 0) return a; //if carry is 0, terminate
        int sum = (a^b);
        int carry = (a&b)<<1;
        return addNumbers(sum, carry);
    }

    public static void main(String[] args) {
        int a = -100;
        int b = 2;
        int sum = addNumbers(a, b);
        System.out.println("Sum of " + a +" and " + b +" is: " + sum );
    }
}
