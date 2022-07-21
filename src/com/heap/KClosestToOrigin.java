package com.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Important things to note:
 * 1. We don't store all the points in the heap. We just store 'k' points in the heap.
 * 2. To find the minimum distance points from the origin, we use a MAX-HEAP.
 * 3. Using QuickSelect can optimise the solution further to O(n).
 */
class PointData{
    int point[];
    double distance;

    public PointData(int[] point, double distance) {
        this.point = point;
        this.distance = distance;
    }

    public int[] getPoint() {
        return point;
    }
}

public class KClosestToOrigin {

    private static int[][] kClosest(int points[][], int k){
        /*Create a max heap*/
        PriorityQueue<PointData> pq = new PriorityQueue<>(k, (p1, p2)->{
            if(p1.distance<p2.distance) return 1;
            if(p1.distance>p2.distance) return -1;
            return 0;
        });
        /*This is the same above initialisation of queue*/
        //PriorityQueue<PointData> pq = new PriorityQueue<>(k, (p1, p2)->  (int)(p2.distance-p1.distance));

        List<PointData> pointsWithDist = new ArrayList<>(points.length);
        for(int i = 0; i < points.length; i++){
            pointsWithDist.add(new PointData(points[i],getDistance(points[i])));
            if(i < k){
                pq.add(new PointData(points[i],getDistance(points[i])));
            }
        }

        for(int i=k; i < points.length; i++){
            if(pointsWithDist.get(i).distance < pq.peek().distance){
                pq.poll();
                pq.add(new PointData(points[i],getDistance(points[i])));
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = pq.poll().getPoint();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }

    private static double getDistance(int[] p){
        return Math.sqrt(p[0]*p[0] + p[1]*p[1]);
    }



    public static void main(String[] args) {
        int points[][] = {{-2,4},{0,-2},{-1,0},{3,5},{3,2},{-2,-3}};
        int k = 3;
        int closestKPoints[][] = kClosest(points,k);
        for(int i=0;i<closestKPoints.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(closestKPoints[i][j]+" ");
            }
            System.out.println("");
        }

    }


}


