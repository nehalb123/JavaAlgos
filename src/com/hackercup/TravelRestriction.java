package com.hackercup;

import com.graph.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TravelRestriction {
    /**
     * https://www.facebook.com/codingcompetitions/hacker-cup/2020/qualification-round/problems/A
     *
     * Instead of graph, we just need an array to store the values.
     * https://drive.google.com/file/d/1kHhWcbygTkWB8HPobtUOSaJaNkQuFkO2/view?usp=sharing
    * */
    static class Node{
        int id;
        Character I;
        Character O;
        Node(int id,Character I,Character O){
            this.id = id;
            this.I = I;
            this.O = O;
        }
        LinkedList<Node> adjacent = new LinkedList();
    }

    static void makeChart(char arr[][], String incoming, String outgoing, int N){
         Node nodes[] = new Node[N];
         for(int i=0;i<N;i++){
             nodes[i] = new Node(i,incoming.charAt(i),outgoing.charAt(i));
         }
         //add path
        for(int i=0;i<N;i++){
            arr[i][i] = 'Y';
            //next airport possible
            if(i <= N-2 && (nodes[i].O == 'Y' && nodes[i+1].I == 'Y')){
                arr[i][i+1] = 'Y';
                nodes[i].adjacent.add(nodes[i+1]);
            }
            //prev airport possible
            if(i > 0 && nodes[i].O == 'Y' && nodes[i-1].I == 'Y'){
                arr[i][i-1] = 'Y';
                nodes[i].adjacent.add(nodes[i-1]);
            }
        }
        //traverse the graph
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> seen = new HashSet<>();
        Node startAirport;
        for(int i=0;i<N;i++){
            seen.clear();
            queue.offer(nodes[i]);
            while(!queue.isEmpty()){
                startAirport = queue.poll();
                if(!seen.contains(startAirport)){
                    seen.add(startAirport);
                }
                for(Node adj: startAirport.adjacent){
                    if(!seen.contains(adj)) {
                        queue.add(adj);
                    }
                    arr[i][adj.id] = 'Y';
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int count=1;
        while(testcases-- > 0) {
            int N = sc.nextInt();
            char arr[][] = new char[N][N];
            String incoming = sc.next();
            String outgoing = sc.next();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j] = 'N';
                }
            }
            makeChart(arr,incoming,outgoing,N);

            System.out.println("Case #"+count+++":");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println("");
            }
        }
    }
}
