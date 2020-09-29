package com.hackercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class TimberDP {
    private static final String BASE_PATH = "/Users/nehalborole/Downloads";
    static File input = new File(BASE_PATH + "/timber_input.txt");
    static Scanner sc;

    static {
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Tree{
        int pos;
        int h;
        Tree(int pos, int h){
            this.pos = pos;
            this.h = h;
        }
    }

    static void combineTimberInterval(){
        int N = sc.nextInt();  //no of trees
        Tree[] trees = new Tree[N];
        for(int i=0;i< trees.length;i++){
            int pos = sc.nextInt();
            int h = sc.nextInt();
            trees[i] = new Tree(pos,h);
        }
        //sort the trees based on pos
        Arrays.sort(trees, (t1,t2) -> (int)(t1.pos - t2.pos));

        HashMap<Integer, Integer> R = new HashMap<>();
        HashMap<Integer, Integer> L = new HashMap<>();

        for(Tree tree : trees){
            int pos = tree.pos;
            int h = tree.h;
            R.put(pos+h,Math.max(R.getOrDefault(pos+h, 0), R.getOrDefault(pos,0)+h));
        }
        //reverse
        Arrays.sort(trees, (t1,t2) -> (int)(t2.pos - t1.pos));
        for(Tree tree : trees){
            int pos = tree.pos;
            int h = tree.h;
            L.put(pos-h,Math.max(L.getOrDefault(pos-h, 0), L.getOrDefault(pos, 0)+h));
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> tree: R.entrySet()){
            int pos = tree.getKey();
            int h = tree.getValue();
            res = Math.max(res, h + L.getOrDefault(pos, 0));
        }

        for(Map.Entry<Integer, Integer> tree: L.entrySet()){
            int pos = tree.getKey();
            int h = tree.getValue();
            res = Math.max(res, h + R.getOrDefault(pos, 0));
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File output = new File(BASE_PATH + "/timber_output.txt");
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int testcases = sc.nextInt();
        for(int i=1; i<=testcases;i++){
            System.out.print("Case #"+i+": ");
            combineTimberInterval();
        }
    }
}
