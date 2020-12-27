package com.greedy;

import java.util.Arrays;
import java.util.HashMap;

public class TaskScheduler2 {

    static int taskScheduler(char tasks[], HashMap<Character, Integer> map){
        //sort on basis of max idle spaces
        int idleSpaces[] = new int[26];
        for(char ch: tasks){
            idleSpaces[ch-'A']++;
        }
        for(char ch: tasks){
            int frequency = idleSpaces[ch-'A'] - 1;
            idleSpaces[ch-'A'] = frequency * map.get(ch);
        }
        Arrays.sort(idleSpaces);

        return 0;
    }

    public static void main(String[] args) {
        char tasks[] = {'A','A','B','B'};
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 3);
        map.put('B', 2);
        int time = taskScheduler(tasks, map);
    }
}
