package com.arrays;


/**
 * Rating: ⭐ ⭐ ⭐ ⭐
 * Diagram: https://imgur.com/lLeYQAN
 */
public class BestTimeToBuySellStocksWithCooldown {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int inHand[] = new int[n];
        int sold[] = new int[n];
        int noStock[] = new int[n];
        inHand[0] = -prices[0];
        for(int i=1; i < n; i++){
            noStock[i] = Math.max(noStock[i-1], sold[i-1]);
            inHand[i] = Math.max(inHand[i-1], noStock[i-1] - prices[i]);
            sold[i] = inHand[i] + prices[i];
        }

        return Math.max(sold[n-1], Math.max(noStock[n-1], inHand[n-1]));
    }

    public static void main(String[] args) {
        int prices[] = {1,2,3,0,2};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: "+ maxProfit);
    }


}
