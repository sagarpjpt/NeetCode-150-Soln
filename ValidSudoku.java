/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/ 
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //chheck each row
        for(int i = 0; i < 9; i++){

            boolean[] repeated = new boolean[10];
            for(int j = 0; j < 9; j++){

                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if (repeated[num]) return false;
                    repeated[num] = true;
                }
            }
        }

        // check each column
        for(int j = 0; j < 9; j++){

            boolean[] repeated = new boolean[10];
            for(int i = 0; i < 9; i++){

                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if (repeated[num]) return false;
                    repeated[num] = true;
                }
            }
        }

        // check each 3x3 box
        for(int boxRow = 0; boxRow < 3; boxRow++){

            for(int boxCol = 0; boxCol < 3; boxCol++){

                boolean[] repeated = new boolean[10];
                for(int i = 0; i < 3; i++){

                    for(int j = 0; j < 3; j++){

                        char c = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (c != '.') {
                            int num = c - '0';
                            if (repeated[num]) return false;
                            repeated[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
