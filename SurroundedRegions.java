/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
*/ 
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                // approach is that start from border where 0 present and from each 0 cell on border start
                // a dfs and mark all the reachable 0 from border to # ---> these # cell are not the surrounded cell
                if((i == 0 || j == 0 || i == row-1 || j == col-1) && board[i][j] == 'O')
                {    
                    dfs(board, i, j);
                }
            }
        }

        //all the remaining 0 cell are the surrounded cell and mark them as 1 and mark # cell back to 0
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        int r = board.length;
        int c = board[0].length;

        if(i < 0 || j < 0 || i >= r || j >= c || board[i][j] != 'O')
            return;
        
        board[i][j] = '#';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }
}
