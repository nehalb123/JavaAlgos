package com.bit;

public class CountBits {
    public static void main(String[] args) {
        int num = 0b0110111;
        int count = 0;
        while(num > 0){
            count += (num  & 1);
            num = num >> 1;
        }
        System.out.println(count);
    }
}
