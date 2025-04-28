/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/ 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        int low = 0, high = r-1, mid = 0, row = -1;

        while(low <= high){
            mid = low + (high - low) / 2;
            if(target <= matrix[mid][c-1]){
                row = mid;
                high = mid - 1;
            }
            else
                low = mid+1;
        } 

        if(row == -1) return false;

        low = 0; high = c - 1;

        while(low <= high){   
            mid = low + (high - low) / 2;
            if(target < matrix[row][mid])
                high = mid-1;
            else if(target > matrix[row][mid])
                low = mid + 1;
            else 
                return true;
        }
        return false;
    }
}
