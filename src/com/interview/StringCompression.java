package com.interview;

public class StringCompression {
/*
Hint: Pointers approach.
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
*/
    public static int compress(char[] chars) {
        int len = chars.length;
        int i = 0;
        int j = 0;
        int saveCount = 0;
        while(i < len){
            while(j < len && chars[i]==chars[j]){
                j++;
            }
            chars[saveCount++] = chars[i];
            if((j-i)>=2){
                for(char ch: String.valueOf(j-i).toCharArray()){
                    chars[saveCount++] = ch;
                }
            }
            i = j;
        }
        return saveCount;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','a','a'};
        int len = compress(chars);
        System.out.println(len);

    }
}
