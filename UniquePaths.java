/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/ 

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        int i = 0, j = 0;
        return help(dp, m, n, i, j);
    }

    private int help(int[][] dp, int m, int n, int i, int j){
        if(i == m-1 && j == n-1) return 1;
        if(i > m-1 || j > n-1) return 0;
        
        if(dp[i][j] != 0) return dp[i][j]; //to avoid overlapping subproblems

        int down = (i+1 < m) ? help(dp, m, n, i+1, j) : 0;  //going down 
        int right = (j+1 < n) ? help(dp, m, n, i, j+1) : 0; //going right

        dp[i][j] = down + right;
        return dp[i][j];
    }
}
