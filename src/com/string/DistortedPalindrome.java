package com.string;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/ENCD12
 */
public class DistortedPalindrome {

    static boolean isValid(String s) {
        int arr[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        int odd = 0;
        for(int n : arr){
            if(n%2 == 1) odd++;
        }
        return odd <= 1;
    }

    static int distortedPalindromes(String s) {
        int left = 0;
        int right = s.length() - 1;
        int matchPtr = 0;
        char c[] = s.toCharArray();
        int minSwaps = 0;

        while (left < right) {
            if (c[left] == c[right]) {
                //everything is in-place; move ahead
                left++;
                right--;
            } else {
                matchPtr = right;
                while (matchPtr > left && c[left] != c[matchPtr])
                    matchPtr--;
                if (matchPtr == left) { //no match found, probably this is a single char
                    char temp = c[matchPtr];
                    c[matchPtr] = c[matchPtr + 1];
                    c[matchPtr + 1] = temp;
                    minSwaps++;
                } else {
                    // place the char to correct position
                    while (matchPtr < right) {
                        char temp = c[matchPtr];
                        c[matchPtr] = c[matchPtr + 1];
                        c[matchPtr + 1] = temp;
                        matchPtr++;
                        minSwaps++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return minSwaps;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if ("0".equals(s)) break;
            if (!isValid(s)) System.out.println("Impossible");
            else {
                int minSwaps = distortedPalindromes(s);
                System.out.println(minSwaps);
            }
        }


    }
}