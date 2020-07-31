package com.numbertheory;

public class ReverseInteger {

    /*Important: Overflow may happen for large integers.
    * */
    static int reverse(int n) {
        int rev = 0;
        int lastDigit;
        while(n != 0){
            lastDigit = n%10;
            //handling overflow
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && lastDigit > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && lastDigit < -8)) return 0;
            rev = (rev*10) + lastDigit;
            n/=10;
        }

        return rev;
    }
    public static void main(String[] args) {
        System.out.println(reverse(3242));
        System.out.println(reverse(1534236469));
    }
}
