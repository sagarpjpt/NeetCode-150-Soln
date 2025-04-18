/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/ 
class Solution {
    public void setZeroes(int[][] matrix) {
        
        // storing the ij where Aij == 0
        List<int []> list = new ArrayList<>();
        int r = matrix.length, c = matrix[0].length;

        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(matrix[i][j] == 0)
                    list.add(new int[]{i,j});
            }
        }

        //making row and column of ij to 0 where Aij = 0
        for(int[] curr : list){

            //set ith row to 0
            int i = curr[0];
            for(int k = 0;k < c;k++)
                matrix[i][k] = 0;

            //set jth col to 0
            int j = curr[1];
            for(int k = 0;k < r;k++)
                matrix[k][j] = 0;
        }
    }
}
