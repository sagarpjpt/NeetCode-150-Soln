/*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
*/ 
class Solution {
    public int swimInWater(int[][] grid) {
        // len of grid
        int n = grid.length;

        // visited array
        boolean isV[][] = new boolean[n][n];

        // min heap ---> (time/max-height, row_ind, col_ind)
        PriorityQueue<Element> pq = new PriorityQueue<>( (a,b) -> a.time - b.time );
        
        // init minheap & visited
        pq.offer(new Element(grid[0][0], 0, 0));

        // possible direction to traverse
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

       while(!pq.isEmpty()){
            Element ele = pq.poll();
            int time = ele.time;
            int row = ele.row;
            int col = ele.col;
            
            // mark popped place visited
            isV[row][col] = true;

            // if popped place is dest then return time/max-height from src to dest
            if(row == n - 1 && col == n - 1)
                return time;

            for(int[] dir : directions){
                int nei_r = row + dir[0]; // neighbour row
                int nei_c = col + dir[1]; // neighbour col
                
                if(nei_r < 0 || nei_c < 0 || nei_r == n || nei_c == n || isV[nei_r][nei_c]){
                    continue;
                }

                pq.offer(new Element(Math.max(time, grid[nei_r][nei_c]), nei_r, nei_c ));
                isV[nei_r][nei_c] = true;
            }
       }
       return 0; 

    }
}

class Element{
    int time;
    int row;
    int col;
    Element(int time, int row, int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}
