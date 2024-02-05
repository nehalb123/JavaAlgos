package com.arrays;

/**
 *  You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
 * to sell that stock.
 *
 */
public class BestTimeToBuySellStocks {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }

}
