package com.numbertheory;

public class IsPalindrome {

    static boolean isPalindrome(int num){
        //Find the divisor to extract the leading digit
        int divisor = 1;
        while(num/divisor >= 10){
            divisor *=10;
        }
        while(num!=0){
            int leading = num/divisor;
            int trailing = num%10;

            if(leading != trailing){
                return false;
            }
            //remove leading and trailing digit
            num = (num % divisor)/10;

            //as two digits are removed divide the divisor
            divisor/=100;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 123321;
        boolean result = isPalindrome(num);
        System.out.println(result);
    }
}
