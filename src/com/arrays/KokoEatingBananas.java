package com.arrays;

/**
 * Approach 1: (Brute force) -> Try all possible values of k.
 * 1. Start from k=1 and check all k values till max(piles).
 * 2. Time Complexity: O(max(piles)*len(piles))
 *
 * Approach 2: (Binary Search)
 * Time Complexity: O(log(max(piles)) * len(piles))
 */
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int pile: piles){
            right = Math.max(right, pile);
        }

        while(left < right){
            int mid = (left + right)/2;
            int totalhours = 0;

            for(int pile : piles){
                totalhours += Math.ceil((double)pile/mid);
            }
            if(totalhours <= h){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        /*both left and right coincide at this point*/
        return left;
    }


    public static void main(String[] args) {
        int piles[] = {3,6,7,11};
        int h = 8;
        int minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed:" + minSpeed);
    }
}
