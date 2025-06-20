/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/ 
class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // storing base case ie if either string is empty then the length of other word becomes min no of operation
        for(int i = 0; i <= word1.length(); i++) {
            dp[i][word2.length()] = word1.length() - i;
        }

        for(int j = 0; j <= word2.length(); j++) {
            dp[word1.length()][j] = word2.length() - j;
        }

        // bottom up dp
        for(int i = dp.length - 2;i >= 0;i--){
            for(int j = dp[0].length - 2;j >= 0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]; // i.e. no operation needed
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}
