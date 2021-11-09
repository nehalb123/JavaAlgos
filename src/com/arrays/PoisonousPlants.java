package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * There are a number of plants in a garden. Each of the plants has been treated with some amount of pesticide.
 * After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.
 *
 * You are given the initial values of the pesticide in each of the plants. Determine the number of days after which no
 * plant dies, i.e. the time after which there is no plant with more pesticide content than the plant to its left.
 */
public class PoisonousPlants {

    public static int poisonousPlants(List<Integer> p) {
        int right = 1;
        LinkedList<LinkedList<Integer>> queues = new LinkedList();
        LinkedList<Integer> q = new LinkedList();
        q.add(p.get(0));
        //create maximal non-increasing chain
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
 * 
 * Explanation 💡:
 *
 * let's say we start with
 *
 * 6 5 8 7 4 7 3 1 1 10
 *
 * we'll represent it as a list of lists like this:
 *
 * monday 6>5, 8>7>4, 7>3>1>1, 10
 *
 * each list is a maximal non-increasing chain
 *
 * now, to let one day pass:
 *
 * pop the top element from every list (excluding the unique leftmost list). these are the plants that die on this day.
 * tuesday 6>5, 7>4, 3>1>1, -
 *
 * now check to see if any adjacent lists can be merged. here we see that 7>4 and 3>1>1 can be merged to form a longer
 * chain. lists can be merged in O(1)
 * tuesday 6>5, 7>4>3>1>1
 *
 * one day has now passed. repeat the process.
 * wednesday 6>5, 4>3>1>1
 *
 * wednesday 6>5>4>3>1>1
 *
 * now that just one list remains in our list, we know we are done.
 */