/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/ 

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, r = matrix.length, c = matrix[0].length;
        boolean visited[][] = new boolean[r][c];
        List<Integer> list = new ArrayList<>();

        do {
            //going right
            while(j < c && !visited[i][j] ){
                visited[i][j] = true;
                list.add(matrix[i][j]);
                j++;
            }

            //going down
            i++;j--;
            while(i < r && !visited[i][j] ){
                visited[i][j] = true;
                list.add(matrix[i][j]);
                i++;
            }

            //going left
            i--;j--;
            while(j >=0 && !visited[i][j] ){
                visited[i][j] = true;
                list.add(matrix[i][j]);
                j--;
            }

            //going up
            j++;i--;
            while(i >= 0 && !visited[i][j] ){
                visited[i][j] = true;
                list.add(matrix[i][j]);
                i--;
            }
            if(i < r-1) i++;
            if(j < c-1) j++;
        }while(!visited[i][j]);

        return list;
    }
}
