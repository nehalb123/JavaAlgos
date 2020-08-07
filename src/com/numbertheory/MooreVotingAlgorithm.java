package com.numbertheory;

public class MooreVotingAlgorithm {

    static int majorityElement(int arr[]){
        int ptr = 0;
        int count = 1;
        /*Find the candidate*/
        for(int i=1;i<arr.length;i++){
            if(arr[ptr]==arr[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                ptr = i;
                count = 1;
            }
        }
        /*Check if it has majority*/
        int candidate = arr[ptr];
        int countOfCandidate = 0;
        for(int i=0;i<arr.length;i++){
            if(candidate == arr[i]){
                countOfCandidate++;
            }
        }
        if(countOfCandidate < arr.length/2){
            System.out.println("No majority element");
            return -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,3,7,3};
        int majorityElement = majorityElement(arr);
        System.out.println("Majority Element: "+majorityElement);
    }
}
