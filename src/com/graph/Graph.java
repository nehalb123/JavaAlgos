package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    static class Node{
        int id;
        LinkedList<Node> adjacent = new LinkedList();
        Node(int id){
            this.id = id;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Node> network = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertices:");
        int vertices = sc.nextInt();
        int from, to,edges;
        System.out.println("Enter memberId:");
        for(int i=0;i<vertices;i++){
            to = sc.nextInt();
            network.put(to,new Node(to));
        }
        System.out.println("Enter no. of edges:");
        edges = sc.nextInt();
        Node curr, target;
        System.out.println("Enter the edge(u,v):");
        for(int i=0;i<edges;i++){
            from = sc.nextInt();
            to = sc.nextInt();
            curr = network.get(from);  //get value of FROM
            curr.adjacent.add(network.get(to));       //add TO to the from's list

            /* For an undirected graph
            curr = network.get(to);
            curr.adjacent.add(network.get(from));
            */
        }
        System.out.println("Enter the follower memberId:");
        from = sc.nextInt();
        System.out.println("Following memberId:");
        to = sc.nextInt();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(network.get(from));
        target = network.get(to);
        while(!queue.isEmpty()){
            curr = queue.poll();
            for(Node member: curr.adjacent){
                if(member == target){
                    System.out.println("Found");
                    return;
                }
                if(network.remove(member.id) == member){
                    queue.offer(member);
                }
            }
        }
        System.out.println("Not Found");
    }
}
