package com.hackercup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Timber {

    static class Tree{
        int id;
        int pos;
        int height;
        int fallLeft;
        int fallRight;

        Tree(int id, int pos, int height, int left, int right){
            this.id = id;
            this.pos = pos;
            this.height = height;
            this.fallLeft = left;
            this.fallRight = right;
        }
    }

    static void calcTimberInterval(Tree[] trees, HashMap<Integer,Tree> t){
        int maxTimberInterval = 0;
        for(int i=0;i<trees.length;i++) {
            if (t.containsKey(trees[i].fallRight)) {
                //if tree exists
               Tree tree =  t.get(trees[i].fallRight);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int count=1;
        while(testcases-- > 0) {
            int N = sc.nextInt();
            Tree[] trees = new Tree[N];
            HashMap<Integer,Tree> t = new HashMap();
            for(int i=0;i<N;i++){ // for each tree get position and height
                int pos = sc.nextInt();
                int height = sc.nextInt();
                trees[i] = new Tree(i, pos, height, pos-height, pos+height);
                t.put(pos, trees[i]);
            }
            calcTimberInterval(trees, t);
        }
    }
}
