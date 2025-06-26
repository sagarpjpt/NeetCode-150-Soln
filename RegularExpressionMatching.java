/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
*/ 

class Solution {
    Boolean dp[][]; // init stores null
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p){

        if(dp[i][j] != null) return dp[i][j]; 

        if(i >= s.length() && j >= p.length())
            return true;

        if(j >= p.length())
            return false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            dp[i][j] = dfs(i, j+2, s, p) // dont use the *
                || (match && dfs(i+1, j, s, p)); // use the * 
        
            return dp[i][j];
        }

        if(match){
            dp[i][j] = dfs(i+1, j+1, s, p);
            return dp[i][j];
        }

        dp[i][j] = false;
        return dp[i][j];

    }

    /*
        BRUTE FORCD ----> USING RECURSION --- DFS

        private boolean dfs(int i, int j, String s, String p){
        if(i >= s.length() && j >= p.length())
            return true;

        if(j >= p.length())
            return false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            return dfs(i, j+2, s, p) // dont use the *
                || (match && dfs(i+1, j, s, p)); // use the * 
        }

        if(match)
            return dfs(i+1, j+1, s, p);

        return false;

    }   
    */ 
}
