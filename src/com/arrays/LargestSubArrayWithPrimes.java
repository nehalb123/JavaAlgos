package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find out a subarray from the given array which starts and ends in a prime number and which
 * has minimum count of -ve numbers in it.
 */
public class LargestSubArrayWithPrimes {

    static void segSieve(int n, boolean isPrime[]){
        for(int p=2; p*p <= n; p++){
            if(isPrime[p]){
                for(int i = p*p; i <= n; i+=p){
                    isPrime[i] = false;
                }
            }
        }
    }

    static void findSubArrayWithPrime(int arr[]){
        int n = arr.length;
        int max_element = Arrays.stream(arr).max().getAsInt();
        boolean isPrime[] = new boolean[max_element+1];
        Arrays.fill(isPrime, true);
        int prefixArr[] = new int[n];

        segSieve(max_element, isPrime);

        prefixArr[0] = arr[0] < 0 ? 1 : 0;
        for(int i=1;i<n;i++){
            prefixArr[i] = prefixArr[i-1];
            if(arr[i] < 0){
                prefixArr[i] += 1;
            }
        }

        List<Integer> primesIndex = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i] >=2 && isPrime[arr[i]]){
                primesIndex.add(i);
            }
        }

        int start = 0, end = 1, minNegNumbers = n, ans = 1, negNumbers, subArraySize;

        while(start < end){
            while(end < primesIndex.size()){
                negNumbers = prefixArr[primesIndex.get(end)] - prefixArr[primesIndex.get(start)];
                subArraySize = primesIndex.get(end) - primesIndex.get(start)+1;

                if(negNumbers > minNegNumbers)
                    break;

                if(negNumbers < minNegNumbers){
                    minNegNumbers = negNumbers;
                    ans = subArraySize;
                }else {
                    ans = Math.max(ans, subArraySize);
                }

                System.out.println(arr[primesIndex.get(start)] + " " + arr[primesIndex.get(end)] + " " + negNumbers);
                end++;
            }
            if(end == primesIndex.size())
                end--;

            start++;
        }

        System.out.println("Length of max subarray: " + ans);
    }

    public static void main(String[] args) {
        int arr[] = {1,2, -3, -4, 3,4,5, -1, 7};
        findSubArrayWithPrime(arr);
    }
}
