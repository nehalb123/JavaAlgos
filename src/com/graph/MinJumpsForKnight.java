package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: Given a square chessboard of N x N size, the position of Knight and position of a target.
 * We need to find out the minimum steps a Knight will take to reach the target position.
 *
 * Method used: BFS
 */
public class MinJumpsForKnight {
    static class Box {
        int x, y;
        int dis;

        public Box(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isInside(int x, int y, int N) {
        if (x >= 0 && x <= N && y >= 0 && y <= N)
            return true;
        return false;
    }

    static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        Queue<Box> q = new LinkedList<>();
        q.add(new Box(startRow, startCol, 0));

        Box t;
        int x, y;
        boolean visit[][] = new boolean[n+1][n+1];

        visit[startRow][startCol] = true;

        while (!q.isEmpty()) {
            t = q.poll();
            if (t.x == endRow && t.y == endCol)
                return t.dis;
            //BFS
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                if (isInside(x, y, n) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new Box(x, y, t.dis + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 6;
        int startRow = 5;
        int startCol = 1;
        int endRow = 0;
        int endCol = 5;
        System.out.println("Minimum jumps for Knight to reach target: "+minMoves(N, startRow, startCol, endRow, endCol));
    }
}
