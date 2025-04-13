/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some 
characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
*/ 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m][n];

        for(int i = 0;i < m;i++)
            for(int j = 0;j< n;j++)
                dp[i][j] = -1;

        return help(dp, text1, text2, m-1, n-1);
    }

    private int help(int[][] dp, String x, String y, int m, int n){
        if(m == -1 || n == -1) return 0;

        if(x.charAt(m) == y.charAt(n)){
            if(dp[m][n] != -1)
                return dp[m][n];
            dp[m][n] = 1 + help(dp, x, y, m-1, n-1);
            return dp[m][n];
        }

        else{
            if(dp[m][n] != -1)
                return dp[m][n];
            dp[m][n] = Math.max(help(dp, x, y, m-1, n), help(dp, x, y, m, n-1));
            return dp[m][n];
        }

    }
}
