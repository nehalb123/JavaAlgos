package com.math;

import java.util.Scanner;

public class NextSmallestPalindrome {

    static boolean isAll9(int num[]){
        for (int i=0;i<num.length;i++){
            if(num[i]!=9)
                return false;
        }
        return true;
    }

    static void nextPalindrome(int num[]){
        if(isAll9(num)){
            int number =0;
            for(int i=0;i<num.length;i++){
                number+=num[i];
                if(i<num.length-1)
                    number*=10;
            }
            number+=2;
            System.out.println(number);
        }else {
            int mid = num.length / 2;
            int left = mid - 1;
            int right = (num.length % 2 == 0) ? mid : mid + 1;
            int carry =0;
            while (left >= 0 && num[left] == num[right]) {
                left--;
                right++;
            }
            if (num.length % 2 == 0) {
                //number is even
                if(left < 0 || num[left] < num[right]){
                    left = mid-1;
                    right = mid;
                    num[left]++;
                    if(num[left] == 9) {
                        carry = 1;
                    }

                }
            } else {
                //odd number
                if (left < 0 || num[left] < num[right]) {
                    left = mid-1;
                    right = mid+1;
                    num[mid]++;
                    carry = num[mid]/10;
                    num[mid]%=10;
                }
            }
            //mirror left part
            while (left >= 0) {
                num[left]+=carry;
                carry = num[left]/10;
                num[left] %=10;
                num[right] = num[left];
                left--;
                right++;
            }
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

            System.out.println("Enter a number:");
            Integer num = s.nextInt();
            String number = num.toString();
            int arr[] = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                arr[i] = number.charAt(i) - '0';
            }
            nextPalindrome(arr);

    }
}
