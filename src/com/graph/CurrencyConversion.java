package com.graph;

import java.util.*;

public class CurrencyConversion {

    static class Node{
        String start;
        String end;
        double ratio;

        Node(String s, String e, double r){
            this.start = s;
            this.end = e;
            this.ratio = r;
        }

    }


    public static double getRatio(String start, String end, List<Node> data){
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(Node node: data){
            //add conversions from both sides i.e (USD to JPY) and (JPY to USD)
            if (!map.containsKey(node.start)) map.put(node.start, new HashMap());
            map.get(node.start).put(node.end, node.ratio);
            if (!map.containsKey(node.end)) map.put(node.end, new HashMap());
            map.get(node.end).put(node.start, 1.0/node.ratio);
        }

        Queue<String> q = new LinkedList();
        Queue<Double> val = new LinkedList();
        q.offer(start);
        val.offer(1.0);
        Set<String> visited = new HashSet();
        visited.add(start);

        double max = -1.0;

        //BFS
        while(!q.isEmpty()){
            String cur = q.poll();
            double num = val.poll();

            if(map.containsKey(cur)){
                Map<String, Double> next = map.get(cur);
                for(String key : next.keySet()){
                    if(key.equals(end)){
                        //compute max
                        max = Math.max(max, num*next.get(key));
                        continue;
                    }
                    if(!visited.contains(key)){
                        q.offer(key);
                        visited.add(key);
                        val.offer(num*next.get(key));
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Node> data = new ArrayList<Node>();
        data.add(new Node("USD", "JPY", 110));
        data.add(new Node("USD", "AUD", 1.45));
        data.add(new Node("JPY", "GBP", 0.0070));
        System.out.println(getRatio("GBP", "AUD", data));
    }
}
