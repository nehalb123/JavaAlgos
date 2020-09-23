package com.greedy;

public class GasStation {

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
     * You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
     */

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int balance = 0;
        int balanceTillNow = 0;
        for(int i=0;i<gas.length;i++){
            balance += (gas[i]-cost[i]);
            if(balance < 0){
                /**
                 * 1. Change start point
                 * 2. Save balanceTillNow (i.e. avoid travelling the loop again)
                 * 3. Reset balance
                 */
                start = i+1;
                balanceTillNow+=balance;
                balance = 0;
            }
        }
        if(balance+balanceTillNow>=0){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        int index = canCompleteCircuit(gas, cost);
        System.out.println(index);
    }
}
