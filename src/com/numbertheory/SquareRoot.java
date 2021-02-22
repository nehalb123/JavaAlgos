package com.numbertheory;

public class SquareRoot {

    static int squareRoot(int num){
        if(num == 0 || num == 1)
            return num;
        int left = 0;
        int right = num;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid*mid == num){
                return mid;
            }
            if(mid*mid < num){
                left = mid+1;
                ans = mid;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 32;
        System.out.println(squareRoot(num));
    }
}
