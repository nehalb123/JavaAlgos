package com.string;

/**
 * Levenshtein distance
 * Reference: https://algodaily.com/challenges/levenshtein-edit-distance
 * 72. Edit Distance: DP + String
 */
public class EditDistances {

        static void print(int dp[][]){
            for(int i=0; i < dp.length; i++){
                for(int j=0; j < dp[0].length; j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }

        static int minDistance(String word1, String word2) {
            int n = word1.length(); //rows
            int m = word2.length(); //cols
            int dp[][] = new int[n+1][m+1];
            dp[0][0] = 0;
            //populating row
            for(int i=1;i<=n;i++){
                dp[i][0] = dp[i-1][0] + 1;
            }
            for(int j=1; j<=m;j++){
                dp[0][j] = dp[0][j-1] + 1;
            }

            for(int i=1; i <= n; i++){
                for(int j=1; j <= m; j++){
                    if(word1.charAt(i-1) != word2.charAt(j-1)){
                        dp[i][j] = Math.min(dp[i-1][j] + 1, Math.min(dp[i-1][j-1]+1, dp[i][j-1]+1));
                    }else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            print(dp);
            return dp[n][m];
        }

    public static void main(String[] args) {
        int distance = minDistance("best", "test");
        System.out.println("Distance: " + distance);
    }
}
