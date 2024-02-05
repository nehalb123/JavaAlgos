package com.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFSGraph {

    static class Node{
        int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        Node(int id){
            this.id = id;
        }
    }

    static boolean dfs(Node src, Node target, boolean visited[]){
        if(visited[src.id]){
            return false;
        }
        System.out.println(src.id);
        if(src.id == target.id){
            return true;
        }
        visited[src.id] = true;
        Iterator<Node> itr = src.adjacent.listIterator();  //keep track of the fringe at root
        while(itr.hasNext()){
            Node curr = itr.next();
                 if(dfs(curr, target, visited)) {
                     return true;
                 }
        }
        return false;
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
        Node curr, src, target;
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

        src = network.get(from);
        target = network.get(to);
        boolean visited[] = new boolean[vertices];
        if(dfs(src, target, visited)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
/*

 */