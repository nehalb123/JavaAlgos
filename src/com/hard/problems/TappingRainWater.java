package com.hard.problems;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=zdDeV5v_iUE
 * */

public class TappingRainWater {

    static void tappingRainwater(int elevation[]){
        int len = elevation.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int waterUnits = 0;
        for(int i=1; i<len; i++){
            left[i] =  Math.max(elevation[i-1],left[i-1]);
        }
        for(int i=len-2; i>=0; i--){
            right[i] = Math.max(elevation[i+1],right[i+1]);
        }
        for (int i =0; i<len ;i++){
            int min = Math.min(left[i],right[i]);
            if(min - elevation[i] > 0){
                waterUnits += (min - elevation[i]);
            }
        }
        System.out.println("Water Trapped: "+waterUnits);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcases:");
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            System.out.println("Enter len of array:");
            int len = sc.nextInt();
            int arr[] = new int[len];
            System.out.println("Enter elevation array Sample:[0,1,0,2,1,0,1,3,2,1,2,1]:");
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            tappingRainwater(arr);
        }
    }
}
