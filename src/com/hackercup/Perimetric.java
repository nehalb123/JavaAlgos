package com.hackercup;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Perimetric {

    static class Point {
        long l;
        long h;
        String pos;

        Point(long l, long h, String pos) {
            this.l = l;
            this.h = h;
            this.pos = pos;
        }
    }

    private static final long MOD = 1000000007;
    private static final String BASE_PATH = "/Users/nehalborole/Downloads";

    public static void main(String[] args) throws Exception {
        File input = new File(BASE_PATH + "/perimetric_chapter_1_sample_input.txt");
        Scanner sc = new Scanner(input);

        File output = new File(BASE_PATH + "/perimetric_chapter_1_sample_output.txt");
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int t = sc.nextInt();
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int w = sc.nextInt();
            long[] l = getArray(sc, n, k);
            long[] h = getArray(sc, n, k);
            System.out.println("Case #" + test + ": " + solve(n, w, l, h));
        }
    }

    private static long solve(int n, int w, long[] l, long[] h) {
        long l_end[] = new long[l.length];
        ArrayList<Long> perimeters = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l_end[i] = l[i] + w;
            points.add(new Point(l[i], h[i], "start"));
            points.add(new Point(l_end[i], h[i], "end"));
        }
        /*Collections.sort(points, (p1, p2) ->  {
            if(p1.l == p2.l) return (int) (p1.h - p2.h);
            return 1;
        });*/
        long start_x = points.get(0).l;
        long height = 0;
        long end_x = points.get(0).l + w;
        long perimeterTillNow = 0;
        long p_disjoint = 0;
        boolean disjoint = false;
        long end = end_x;
        for (Point p : points) {
            if (p.pos.equals("end")) {
                height = Math.max(height, p.h);
                end_x = Math.max(end_x, p.l);
                perimeterTillNow = (disjoint) ? (end_x - start_x + height) * 2 + p_disjoint : (end_x - start_x + height) * 2;
                perimeters.add(perimeterTillNow);
            }
            if (p.pos.equals("start")) {
                if (p.l > end) {
                    //update start_x
                    start_x = p.l;
                    //reset
                    height = p.h;
                    p_disjoint = perimeterTillNow;
                    disjoint = true;
                }
                end = p.l + w;
            }
        }
        //product
        long product = perimeters.get(0);
        for (int i = 1; i < perimeters.size(); i++) {
            product = ((perimeters.get(i)) * (product)) % MOD;
        }
        return product;
    }

    private static long[] getArray(Scanner sc, int n, int k) {
        long[] array = new long[n];
        for (int i = 0; i < k; ++i) {
            array[i] = sc.nextLong();
        }
        long a, b, c, d;
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        d = sc.nextLong();
        for (int i = k; i < n; ++i) {
            array[i] = ((a * array[i - 2] + b * array[i - 1] + c) % d) + 1;
        }
        return array;
    }
}

