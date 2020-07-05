package com.medium.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindThreeSum {

    static List<List<Integer>> find3Sum(int arr[]){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int threeSum = arr[i] + arr[left] + arr[right];
                if(threeSum > 0){
                    right--;
                }else if(threeSum < 0){
                    left++;
                }else{
                    ArrayList<Integer> found = new ArrayList<>();
                    found.add(arr[i]);
                    found.add(arr[left]);
                    found.add(arr[right]);
                    result.add(found);
                    left++;
                    while(left < right && arr[left] == arr[left-1]){
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,3,4,-3,1,2};
        System.out.println(find3Sum(arr));

    }
}
