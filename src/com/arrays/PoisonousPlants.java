package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PoisonousPlants {

    public static int poisonousPlants(List<Integer> p) {
        int right = 1;
        LinkedList<LinkedList<Integer>> queues = new LinkedList();
        LinkedList<Integer> q = new LinkedList();
        q.add(p.get(0));
        while(right < p.size()){
            //scan the array
            if(p.get(right) > p.get(right-1)){
                //split the list
                queues.add(q);
                q = new LinkedList();
            }
            q.add(p.get(right));
            right++;
        }
        queues.add(q);

        int count = 0;
        while(queues.size() > 1){
            Iterator it = queues.iterator();
            LinkedList<Integer> start = (LinkedList<Integer>)it.next();

            while(it.hasNext()){
                q = (LinkedList<Integer>)it.next();
                q.poll();
                if(q.size() == 0){
                    it.remove();
                } else if(start.getLast() >= q.peek()){
                    start.addAll(q);
                    it.remove();
                } else{
                    start = q;
                }
            }
            count++;
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> plants = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int count = poisonousPlants(plants);
        System.out.println("No. of days: "+ count);
    }
}

/**
 * Sample input: 20 5 6 15 2 2 17 2 11 5 14 5 10 9 19 12 5
 * Expected o/p: 4
 *
 * i/p: 2 1 10 9 8 7 6 5 4 3
 * o/p: 8
 */