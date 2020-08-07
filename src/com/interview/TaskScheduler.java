package com.interview;

import java.util.Arrays;

public class TaskScheduler {

    static int taskScheduler(char tasks[], int coolDownDuration){
        if(coolDownDuration == 0){
            return tasks.length;
        }
        int frequency[] = new int[26];
        //calculate frequency
        for(char ch: tasks){
            frequency[ch-'A']++;
        }
        Arrays.sort(frequency);
        //calculate max idle spaces possible
        int chunksWithSpaces = frequency[25]-1;
        int spaces = chunksWithSpaces * coolDownDuration;
        //put the char in spaces virtually i.e. each chunk must get one char
        for(int i=24;i>=0;i--){
            spaces-=Math.min(chunksWithSpaces, frequency[i]);
            if(spaces <=0){
                break;
            }
        }
        int idleSpaces = Math.max(0, spaces);
        return tasks.length + idleSpaces;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A', 'B','B','B','C','C','C'};
        int coolDownDuration = 1;
        System.out.println(taskScheduler(tasks, coolDownDuration));

    }
}
