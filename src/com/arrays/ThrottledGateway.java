package com.arrays;

/**
 * Problem Statement: https://imgur.com/T3P8Z6R
 * TODO: Diagram?
 *
 * Approach: As the request times are sorted in ascending order,
 * 1. check if last 3 requests hd same time.
 * 2. difference in time for last 20 requests can't be more than 10.
 * 3. difference in the request time for last 60 requests can't be more than 60.
 */
public class ThrottledGateway {

    static int dropRequests(int rt[], int n){
        int drops = 0;
        for (int i=0; i < n; i++){
            if(i >= 3 && rt[i] == rt[i-3]){
                drops++;
                System.out.println("Dropped: "+ (i+1) + " no. request");
            } else if( i >= 20 && rt[i] - rt[i-20] < 10){  /** if count exceeds 20 && requestTime is within the 10 sec duration **/
                drops++;
                System.out.println("Dropped: "+ (i+1) + " no. request");
            } else if( i >= 60 && rt[i] - rt[i-60] < 60){   /** if count exceeds 60 && requestTime is within the 60 sec duration **/
                drops++;
                System.out.println("Dropped: "+ (i+1) + " no. request");
            }
        }
        return drops;
    }

    public static void main(String[] args) {
        int requestTime[] = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11};
        int n = requestTime.length;
        int droppedRequests = dropRequests(requestTime, n);
        System.out.println("Number of dropped requests: "+ droppedRequests);

    }
}
