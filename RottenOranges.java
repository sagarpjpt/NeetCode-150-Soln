/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
*/ 
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int min = 0;

        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int row = grid.length;
        int col = grid[0].length;
        int freshCount = 0;

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[] {i, j});
                if(grid[i][j] == 1)
                    freshCount++;
            }
        } 

        while(!q.isEmpty() && freshCount > 0){
            int size = q.size();
            for(int i = 0;i < size;i++) // exiting out of this ensure a level is traversed
            {
                int[] cord = q.poll();
                for(int[] dir : directions) //visiting all the neigbours first
                {
                    int r = cord[0] + dir[0];
                    int c = cord[1] + dir[1];
                    if(r >=0 && c >= 0 && r <row && c < col && grid[r][c] == 1){
                        grid[r][c] = 2;
                        freshCount--;
                        q.offer(new int[] {r, c});
                    }
                }
            }
            min++; // one minute passed after traversing current level
        }
        
        return freshCount == 0 ? min : -1;
    }
}
