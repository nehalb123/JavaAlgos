package com.hackercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Consistency {

    static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }

    static void makeConsistent(String s){
        if(s.length() == 1){
            System.out.println(0);
            return;
        }
        int alphabets[] = new int[26];
        int vowels = 0;
        int consonants = 0;
        for(char ch : s.toCharArray()){
            alphabets[ch - 'a']++;
            if (isVowel(ch)) {
                vowels++;
            } else {
                consonants++;
            }
        }







    }

    public static void main(String[] args) throws FileNotFoundException {
        final String BASE_PATH = "/Users/nehalborole/Downloads";
        File input = new File(BASE_PATH + "/consistency_input.txt");
        Scanner sc = new Scanner(input);
        File output = new File(BASE_PATH + "/consistency_output.txt");
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int testcases = sc.nextInt();
        for(int i=1; i<=testcases;i++){
            System.out.print("Case #"+i+": ");
            String s = sc.next();
            makeConsistent(s);
        }
    }
}
