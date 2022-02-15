package com.bit;

public class PowerOf4 {

    static boolean itrPowerOf4(int num){
        /*Approach 1*/
        if(num == 0)
            return false;
        while(num!=1){
            if(num%4 != 0)
                return false;
            num/=4;
        }
        return true;
    }

    static boolean bitPowerOf4(int num){
        /*
        Approach 2:
        1. n & (n-1) = 0 => for, n = power of 2
           Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
        2. The bits don’t AND(&) any part of the pattern 0xAAAAAAAA
           Why 0xAAAAAAAA ? For powers of 4 only odd number of bits are set.

        */
        int bitMask = 0xAAAAAAAA;
        return num!=0 && ((num & num-1) == 0) && (num & bitMask)==0;
    }

    static boolean bitPowerOf4Another(int num){
        /*
        Approach 2:
        1. n & (n-1) = 0 => for, n = power of 2
           Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
        2. n % 3 == 1, For n = power of 4.
        */
        return num!=0 && ((num & num-1) == 0) && (num % 3)==1;
    }

    public static void main(String[] args) {
        int numberToCheck = 20;
        boolean isPowerOf4 = itrPowerOf4(numberToCheck);
        boolean bitPowerOfFour  = bitPowerOf4(numberToCheck);
        System.out.println(bitPowerOfFour);
    }
}
