package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSumBT {

    static List<List<Integer>> subset = new ArrayList<>();

    static void backtrack(int[] arr, int index, int sum, List<Integer> res) {
        if (index == arr.length) {
            int sumOfList = res.stream().reduce(0, (a, b) -> a + b);
            if (sumOfList == sum) {
                subset.add(new ArrayList<>(res));
            }
            return;
        }
        res.add(arr[index]);
        backtrack(arr, index + 1, sum, res);
        res.remove(res.size() - 1);
        backtrack(arr, index + 1, sum, res);
    }

    static void subsetSum(int[] arr) {
        List<Integer> res = new ArrayList<>();
        backtrack(arr, 0, 25, res);
        System.out.println(subset);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 7, 8};
        List<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toList());
        subsetSum(arr);
    }
}
