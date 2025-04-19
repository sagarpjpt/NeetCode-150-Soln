/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/ 

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        //fill leftmax array
        leftMax[0] = height[0];
        for(int i = 1; i < n;i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        // fill right max arrray 
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0;i--)
            rightMax[i] = Math.max(rightMax[i+1], height[i]);

        // cal total trapped water
        int trapped = 0;
        for(int i = 0; i < n;i++)
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];

        return trapped;
    }
}
