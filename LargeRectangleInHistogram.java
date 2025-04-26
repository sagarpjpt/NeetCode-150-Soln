/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/ 

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}


/*
BURTE FORCE ALGO
class Solution {
    public int largestRectangleArea(int[] heights) {
        int left,right;
        int n = heights.length;
        int res = 0; 
        for(int i = 0;i < n;i++){
            int height = heights[i];
            int width = 1;
            left = i-1;right = i+1;
            
            while(left >= 0 && heights[left] >= height){
                width++;
                left--;
            }
            
            while(right < n && heights[right] >= height){
                width++;
                right++;
            }

            res = Math.max(res, (height * width));
        }
        return res;
    }
}

*/ 
