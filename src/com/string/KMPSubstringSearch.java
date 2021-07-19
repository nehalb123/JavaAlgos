package com.string;

public class KMPSubstringSearch {
    /**  Difficulty: Easy
     *   Runtime complexity - O(m + n) where m is length of text and n is length of pattern.
     *   Space complexity - O(n) - for the prefix array.
    * */

    /**
     *  Computes an array which represents suffix which is also a prefix. The array stores index of location to start from
     *  in case of mismatch. This helps us not to go back entirely in the text.
     *
     *  Is there a suffix which is also a prefix in the pattern string?
     */
    static int[] computeMatchingArray(String p){
        int index = 0;
        int match[] = new int[p.length()];
        match[0] = 0;
        for(int i=1;i<p.length();){
            //if match increment both pointers
            if(p.charAt(index) == p.charAt(i)){
                match[i] = index + 1;
                index++;
                i++;
            }else{
                if(index!=0){
                    index = match[index-1];
                }else {
                    match[i] = 0;
                    i++;
                }
            }
        }
        return match;
    }

    static boolean KMPSearch(String string, String patten){
        // Step 1: Compute the array
        int match[] = computeMatchingArray(patten);
        //Step 2: Searching begins!
        int i=0;
        int j=0;
        while(i<string.length()){
            if(string.charAt(i) == patten.charAt(j)){
                j++;
                i++;
            }else{
                if(j>0){
                    j = match[j-1];
                }else{
                    i++;
                }
            }
            if(j == patten.length()){
                System.out.println("Found at index: " + (i-patten.length()));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String string = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        KMPSearch(string, pattern);
    }
}
