package com.arrays;

import java.util.Stack;

public class Pattern132 {

    static boolean is132Pattern(int arr[]){
        int min[] = new int[arr.length];
        min[0] = arr[0];
        for(int j = 1; j < arr.length; j++){
            min[j] = Math.min(min[j-1], arr[j]);
        }
        Stack<Integer> st = new Stack<>();
        for(int j = arr.length-1; j >= 0; j--){
            while(!st.empty() && st.peek() < arr[j]){
                if(st.peek() > min[j]){
                    return true;
                }
                st.pop();
            }
            st.push(arr[j]);
        }
        return false;

    }

    public static void main(String[] args) {
        boolean result = is132Pattern(new int[]{3,5,0,3,4});
        System.out.println("Has 132 Pattern? " + result);
    }
}
