package com.Design;

public class TokenBucketAlgorithm {

    private final long maxBucketSize;
    private final long refillRate;
    private long lastRefillTimestamp;
    private double currentSize;

    //constructor
    TokenBucketAlgorithm(long maxBucketSize, long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentSize = maxBucketSize;
        lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequests(int tokens){
        refill();
        if(currentSize > tokens){
            currentSize-=tokens;
            return true;
        }
        return false;
    }

    public void refill(){
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimestamp)*refillRate/1e9;
        currentSize = Math.min(currentSize+tokensToAdd, maxBucketSize);
        lastRefillTimestamp = now;
    }
}
