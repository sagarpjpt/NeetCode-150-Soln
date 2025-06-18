/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.
From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
Example 1:
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
*/ 
class Solution {
    int[][] dp;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        int maxPath = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                maxPath = Math.max(maxPath, dfs(i, j, matrix));
        }
        return maxPath;
    }

    private int dfs(int i, int j, int[][] matrix){
        if (dp[i][j] != 0) return dp[i][j];

        int maxLen = 1; // current

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                matrix[x][y] > matrix[i][j]){
                maxLen = Math.max(maxLen, 1 + dfs(x, y, matrix));
            }
        }

        dp[i][j] = maxLen;
        return maxLen;
    }
}
