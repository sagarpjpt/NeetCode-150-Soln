/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
*/ 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //using memoization DP approach
        Set<String> dict = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int len = 1; len <= s.length();len++){
            for(int i = 0; i < len; i++){
                if(dp[i] &&  dict.contains(s.substring(i, len))){
                    dp[len] = true; break;
                }
            }
        }
        return dp[dp.length-1];
    }
}

// TC ---> O(n^2)
