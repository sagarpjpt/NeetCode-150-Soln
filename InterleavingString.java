/*
You are given three strings s1, s2, and s3. Return true if s3 is formed by interleaving s1 and s2 together or false otherwise.
Interleaving two strings s and t is done by dividing s and t into n and m substrings respectively, where the following conditions are met
|n - m| <= 1, i.e. the difference between the number of substrings of s and t is at most 1.
s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
Interleaving s and t is s1 + t1 + s2 + t2 + ... or t1 + s1 + t2 + s2 + ...
You may assume that s1, s2 and s3 consist of lowercase English letters.

Example 1:
Input: s1 = "aaaa", s2 = "bbbb", s3 = "aabbbbaa"
Output: true
*/ 
class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(0, 0, s1, s2, s3);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3){
        if(i == s1.length() && j == s2.length()) return true;
        if(dp[i][j] != null) return dp[i][j];

        int k = i + j;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(i+1, j, s1, s2, s3))
            return true;
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(i, j+1, s1, s2, s3))
            return true;
        dp[i][j] = false;
        return false;
    }
}
