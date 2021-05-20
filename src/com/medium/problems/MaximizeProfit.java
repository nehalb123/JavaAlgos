package com.medium.problems;

import java.util.Scanner;
/*
LOYLOGIC INTERVIEW QUESTION
Algorithms have become so good at predicting the market that you know the share price of a
company(PSV) will be for a number of minutes going forward. \r\n###
Each minute, your high frequency trading platform allows you to either buy one share of PSV,
sell any number of shares of PSV that you own, or not make any transaction at all.
Find the maximum profit you can obtain with an optimal trading strategy.\n
Purchases are negative and sales are positive cash flow.
For Example if predicted prices over the next n = 6 minutes are prices=[3,4,5,3,5,2], one way to the best outcome is to
purchase a share in each of the first 2 minutes -3 + -4 = -7, then sell them at third minute for 2*5=10.
Purchase a share in the 4th minute for 3 and sell it in the 5th minute for 5. Total profits are -3-4+10-3+5= 5.
Another way to the same outcome is to purchase a share in each of the 1st, 2nd and 4th minutes for -3-4-3 = -10,
then sell all three shares at 5(total 3*5 =15), again total profit  of -10 + 15 = 5.
There is no reason to purchase in the last minute as there is no time to sell.

My approach: https://imgur.com/erhCQop
*/

public class MaximizeProfit{

    static void maximizeProfit(int stock[]){
        int len = stock.length;
        int profit = 0;
        int maxSell = stock[len-1];
        for (int i = len-2; i>=0 ; i--){
            profit += Integer.max(0, maxSell - stock[i]);
            //update max every-time we encounter a greater value
            maxSell = Integer.max(stock[i],maxSell);
        }
        System.out.println("Maximum profit: "+profit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcases:");
        int testcases = sc.nextInt();
        for (int i=0; i < testcases; i++){
            System.out.println("Enter len of array:");
            int len = sc.nextInt();
            int arr[] = new int[len];
            System.out.println("Enter stock prices:");
            for(int j=0; j < len; j++){
                arr[j] = sc.nextInt();
            }
            maximizeProfit(arr);
        }
    }
}
