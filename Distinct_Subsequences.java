/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.
Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
*/ 

class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++)
                dp[i][j] = -1;
        }
        return dfs(0, 0, s, t);
    }

    private int dfs(int ind_s, int ind_t, String s, String t){
        if(ind_t == t.length()) return 1;

        if(ind_s == s.length()) return 0;

        if(dp[ind_s][ind_t] != -1) return dp[ind_s][ind_t];

        if(s.charAt(ind_s) == t.charAt(ind_t)){
            dp[ind_s][ind_t] = dfs(ind_s + 1, ind_t + 1, s, t) + dfs(ind_s + 1, ind_t, s, t);
        }
        else{
            dp[ind_s][ind_t] = dfs(ind_s + 1, ind_t, s, t);
        }

        return dp[ind_s][ind_t];
    } 
}
