package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Problem Statement: https://imgur.com/a/FHDEbjB
 *
 * Time Complexity: O(kn)
 */
public class DocumentChunking {

    static int getMinChunks(long N) {
        if (N == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < 64; i++) {
            ans += (N & 1);
            N = N >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalPackets = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        //taking uploaded chunk input
        ArrayList<ArrayList<Integer>> uploadedChunks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ArrayList<Integer> small = new ArrayList<>();
            small.add(start);
            small.add(end);
            uploadedChunks.add(small);
        }
        sc.close();

        Collections.sort(uploadedChunks, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        int choose = 1;
        int ans = 0;
        for (int i = 0; i < uploadedChunks.size(); i++) {
            int start = uploadedChunks.get(i).get(0);
            int end = uploadedChunks.get(i).get(1);
            ans += getMinChunks(start - choose);
            choose = end + 1;
        }

        int lastChunk = uploadedChunks.get(n - 1).get(1);
        if (lastChunk != totalPackets) {
            ans += getMinChunks(totalPackets - lastChunk);
        }
        System.out.println(ans);
    }
}
