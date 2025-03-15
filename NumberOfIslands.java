class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numsOfIsland = 0;

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '1'){
                    numsOfIsland++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return numsOfIsland;
    }
    private void dfs(char[][] grid, int i, int j, int r, int c){
        if(i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i-1, j, r, c);
        dfs(grid, i+1, j, r, c);
        dfs(grid, i, j-1, r, c);
        dfs(grid, i, j+1, r, c);
    }
}
