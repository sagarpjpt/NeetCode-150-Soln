/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each other.
A queen in a chessboard can attack horizontally, vertically, and diagonally.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.' indicates an empty space.
You may return the answer in any order
Example 1
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There are two different solutions to the 4-queens puzzle.
*/ 


class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];

        // Initialize the board with "."
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }

        helper(board, 0);
        return res;
    }

    // Check if placing a queen at (row, col) is safe
    private boolean isValidQueens(String[][] board, int row, int col) {
        int n = board.length;

        // no need to check rows as placing 1 queen at each row at diff co-ord

        // Check the same column upwards
        for (int i = 0; i < row; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        return true; // No conflicts, safe to place queen
    }

    private void helper(String[][] board, int row) {
        int n = board.length;

        // If all rows are processed, add the board configuration to results
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                current.add(sb.toString());
            }
            res.add(current);
            return;
        }

        // Try placing queen in all columns for this row
        for (int col = 0; col < n; col++) {
            if (isValidQueens(board, row, col)) {
                // placing queen
                board[row][col] = "Q";
                
                // recursive call --> each level represent each row of board 
                helper(board, row + 1);       

                // backtrack
                board[row][col] = ".";
            }
        }
    }
}


/*
brute force ---->
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<int[]> queen_cords = new ArrayList<>(); 
    public List<List<String>> solveNQueens(int n) {
        String board[][] = new String[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++)
                board[i][j] = ".";
        }
        helper(board, 0);
        return res;
    }

    private boolean isValidQueens(String board[][], List<int[]> cords) {

        // checking valid queens place
        for(int[] cord : cords){
            int i = cord[0];
            int j = cord[1];
            // no need to check for rows as queen placed row by row

            // check for jth row 
            for(int k = 0;k < board.length;k++){
                if(i != k && !board[k][j].equals("."))
                    return false;
            }
            // check diagonally
            if(
                searchDiagonal(board, i - 1, j - 1, -1, -1, "Q") ||
                searchDiagonal(board, i - 1, j + 1, -1, +1, "Q") ||
                searchDiagonal(board, i + 1, j - 1, +1, -1, "Q") ||
                searchDiagonal(board, i + 1, j + 1, +1, +1, "Q")
            )
                return false;
        }
        return true;
    }

    private boolean searchDiagonal(String[][] mat, int i, int j, int dx, int dy, String target) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Base case: out of bounds
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        // If match found
        if (mat[i][j].equals(target)) {
            return true;
        }

        // Recursive call in the same direction
        return searchDiagonal(mat, i + dx, j + dy, dx, dy, target);
    }

    private void helper(String[][] board, int ind){
        if(ind == board.length){
            if(isValidQueens(board, queen_cords)){
                List<String> sub = new ArrayList<>();
                for(int i = 0;i < board.length;i++){
                    String str = "";
                    for(int j = 0;j < board.length;j++)
                        str += board[i][j];
                    sub.add(str);
                }
                res.add(new ArrayList<>(sub));
            }
            return;
        }

        // exploring all the paths
        for(int k = 0; k < board[0].length;k++){
            // add queen pos to queen cords
            queen_cords.add(new int[] {ind, k});
            board[ind][k] = "Q";

            // recursive calls
            helper(board, ind + 1);

            // backtrack
            queen_cords.remove(queen_cords.size() - 1);
            board[ind][k] = ".";
        }
        
    }
}

*/ 
