package com.medium.problems;

import java.util.Scanner;

public class ContainerWithMostWater {
    /**
     * The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.
     * All other containers are less wide and thus would need a higher water level in order to hold more water.
     * The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.
     */
    static  void containerWithMostWater(int contHeight[]){
        //Double pointer approach: Single pass
        int len = contHeight.length;
        int left = 0;
        int right = len - 1;
        int maxArea = 0;
        while(left < right){
            int min = Math.min(contHeight[left],contHeight[right]);
            maxArea = Math.max(maxArea,((right-left)* min));
            if(contHeight[left] < contHeight[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("Max Water: "+maxArea);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcases:");
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            System.out.println("Enter len of array:");
            int len = sc.nextInt();
            int arr[] = new int[len];
            System.out.println("Enter container height Sample:[1,8,6,2,5,4,8,3,7]:");
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            containerWithMostWater(arr);
        }
    }
}
