package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Difficulty: Easy
 * Idea: Increase the size of window when you find an overlap, else update the window.
 */
public class MergeIntervals {

     static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 1;
        while(i < intervals.length){
            if(intervals[i][0] > end){
                // no overlap
                result.add(new int[]{start,end}); //add existing to list
                start = intervals[i][0];
                end = intervals[i][1];
            } else if(intervals[i][1] > end ){
                //overlap but not complete overlap
                end = intervals[i][1];
            }
            i++;
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int result[][] = merge(intervals);
        for(int i=0; i < result.length; i++){
                System.out.print("[" + result[i][0] + " " + result[i][1] + "]" + " ");
        }

    }
}
