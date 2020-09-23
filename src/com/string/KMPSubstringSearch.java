package com.string;

public class KMPSubstringSearch {
    /**  Difficulty: Easy
     *   Runtime complexity - O(m + n) where m is length of text and n is length of pattern
     *   Space complexity - O(n)
    * */

    /**
     *  Computes an array which represents suffix which is also a prefix. The array stores index of location to start from
     *  in case of mismatch. This helps us not to go back entirely in the text.
     *
     *  Is there a suffix which is also a prefix?
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

    static boolean KMPSearch(String s, String p){
        int match[] = computeMatchingArray(p);
        int i=0;
        int j=0;
        while(i<s.length()){
            if(s.charAt(i) == p.charAt(j)){
                j++;
            }else{
                if(j>0){
                    j = match[j-1];
                    i--;
                }
            }
            if(j == p.length()){
                System.out.println("Found at index: " + (i-p.length()+1));
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcxabcdabcdabcy";
        String p = "abcdabcy";
        KMPSearch(s,p);
    }
}
