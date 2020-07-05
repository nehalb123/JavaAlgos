package com.interview;

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
        1. n & (n-1)  There is only one bit set in the binary representation of n (else n is a power of 2):
           Consider the case of 20..we have to remove this case.
           Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
        2. The bits don’t AND(&) any part of the pattern 0xAAAAAAAA
           Why 0xAAAAAAAA ? This is because the bit representation is of powers of 2 that are not of 4. Like 2, 8, 32 so on..
           For example: 16 (10000) is power of 4 because there is only one bit set and 0x10 & 0xAAAAAAAA is zero.
        */
        int bitMask = 0xAAAAAAAA;
        return num!=0 && ((num & num-1) == 0) && (num & bitMask)==0;
    }


    public static void main(String[] args) {
        int numberToCheck = 20;
        boolean isPowerOf4 = itrPowerOf4(numberToCheck);
        boolean bitPowerOfFour  = bitPowerOf4(numberToCheck);
        System.out.println(bitPowerOfFour);
    }

}
