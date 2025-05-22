/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
*/ 

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++)
                if(grid[i][j] == 1 && visited[i][j] == false){

                    int currArea = dfs(grid, visited, i, j, grid.length, grid[0].length);

                    // save max area
                    maxArea = Math.max(maxArea, currArea);
                }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] v, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0 || v[i][j] == true)
            return 0;
        
        v[i][j] = true;

        return 1 + dfs(grid, v, i, j+1, row, col) + dfs(grid, v, i, j - 1, row, col) + 
            dfs(grid, v, i-1, j, row, col) + dfs(grid, v, i+1, j, row, col);
    }
}
