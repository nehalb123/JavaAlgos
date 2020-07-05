package com.graph;

import java.util.*;

public class WeightedGraph {

    static class Node{
        int id;
        LinkedList<Node> adjacent = new LinkedList();
        LinkedList<Integer> weight = new LinkedList<>();
        Node(int id){
            this.id = id;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Node> network = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertices:");
        int vertices = sc.nextInt();
        int from, to,edges, time;
        System.out.println("Enter memberId:");
        for(int i=0;i<vertices;i++){
            to = sc.nextInt();
            network.put(to,new Node(to));
        }
        System.out.println("Enter no. of edges:");
        edges = sc.nextInt();
        Node curr, next;
        System.out.println("Enter the edge(u,v):");
        for(int i=0;i<edges;i++){
            from = sc.nextInt();
            to = sc.nextInt();
            time = sc.nextInt();
            curr = network.get(from);  //get value of FROM
            curr.adjacent.add(network.get(to));       //add TO to the from's list
            curr.weight.add(time);
        }
        System.out.println("Enter the follower memberId:");
        from = sc.nextInt();
        System.out.println("Following memberId:");
        to = sc.nextInt();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(network.get(from));
        Map<Integer, Integer> fastestTime = new HashMap<>();
        fastestTime.put(from, 0);
        Integer currTime;
        while(queue.size() > 0){
            curr = queue.poll();
            time = fastestTime.get(curr.id);
            for (int i=0;i< curr.adjacent.size();i++){
                next = curr.adjacent.get(i);
                currTime = fastestTime.getOrDefault(next.id,Integer.MAX_VALUE);
                if(currTime > time + curr.weight.get(i)){
                    fastestTime.put(next.id, time+curr.weight.get(i));
                    queue.add(next);
                }
            }
        }
        if(fastestTime.get(to) == null){
            System.out.println(-1);
        }else{
            System.out.println(fastestTime.get(to));
        }
    }
}
