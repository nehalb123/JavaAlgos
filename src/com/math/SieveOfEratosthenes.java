package com.math;

/**
 * Find all prime numbers till n
 */
public class SieveOfEratosthenes {

    static void sieve(int n){

        boolean isPrime[] = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            isPrime[i] = true;
        }
        for(int p = 2; p*p <= n; p++){
            if(isPrime[p] == true){
                for(int i=p*p; i <= n; i += p){  /** Mark multiples of p as 'false' **/
                    isPrime[i] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 50;
        sieve(n);
    }
}
