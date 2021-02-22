package com.arrays;

import java.util.HashSet;
import java.util.Scanner;
/*You are given an integer array.
Constraint: value in the array should be > 0 && <= len
This problem has more efficient approach with no extra space complexity.
*/

public class FirstDuplicate {
    int firstDuplicate(int arr[]){
        //has space complexity
        HashSet seen = new HashSet();
        for(int i=0; i < arr.length; i++){
            if(seen.contains(arr[i])){
                return arr[i];
            } else{
                seen.add(arr[i]);
            }
        }
        return -1;
    }

    public int findDuplicateCycleDetection(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = nums[0], fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = nums[0];
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }
        }
    }

    int firstDuplicateOptimal(int arr[]){
        /*
        Constraint: value in the array should be > 0 && <= len
        most optimal solution
        [2,3,5,3,2]
        [2,-3,5,3,2]
        [2,-3,-5,3,2]
        [2,-3,-5,3,-2]
        [2,-3,-5,3,-2]  2nd index is already negative. Hence duplicate found.
        */
        for(int i=0; i< arr.length; i++){
            if(arr[Math.abs(arr[i])-1] < 0){
                return Math.abs(arr[i]);
            } else{
                arr[Math.abs(arr[i])-1] *= (-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstDuplicate firstDuplicate = new FirstDuplicate();
        int arr[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcase no.:");
         int testcase = sc.nextInt();
        switch(testcase){
            case 1:
                arr = new int[]{2, 1, 3, 5, 3, 2};
                break;
            case 2:
                arr = new int[]{1,2,3,4};
                break;
            default:
                arr = new int[]{1,1,2,2};
        }
        int dup = firstDuplicate.firstDuplicate(arr);
        int dup3 = firstDuplicate.findDuplicateCycleDetection(arr);
        int dup2 = firstDuplicate.firstDuplicateOptimal(arr);

        System.out.println("duplicate:" + dup);
        System.out.println("duplicate:" + dup2);
        System.out.println("duplicate:" + dup3);
    }
}
