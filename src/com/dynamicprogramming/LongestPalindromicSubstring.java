package com.dynamicprogramming;

/**
 * dp table: https://imgur.com/mkZ0hlQ
 */
public class LongestPalindromicSubstring {

    static void print(int dp[][], int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void longestPalindromicSubstring(String s){
        int len = s.length();
        int dp[][] = new int[len][len];

        String res = "";
        int L = 0;
        int R = 0;
        //fill diagonal i.e. len = 1 substring
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        //fill for len = 2 substring
        for(int i = 0; i < len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                L = i;
                R = i+1;
            }
        }
        int col = 2;

        while(col < len){
            for(int i=0; i + col < len; i++){
                if(s.charAt(i) == s.charAt(i+col) && dp[i+1][i+col-1] == 1) {
                    dp[i][i + col] = 1;
                }
                if(dp[i][i+col] == 1 && ( col+1 > R-L) ){
                    //res = s.substring(i,i+col+1);
                    L = i;
                    R = i+col;
                }
            }
            col++;
        }
        res = s.substring(L,R+1);
        System.out.println(res);
        print(dp, len, len);
    }

    public static void main(String[] args) {
        String s = "agabttba";
        longestPalindromicSubstring(s);
    }
}
