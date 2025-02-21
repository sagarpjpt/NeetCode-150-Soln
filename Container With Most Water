class Solution {
    public int maxArea(int[] height) {
        if(height.length == 2) return findMin(height[0],height[1]);
        int maxArea = 1;
        int low = 0,high = height.length-1;
        while(low<high){
            int area = (high-low) * findMin(height[low],height[high]);
            maxArea = (maxArea<area) ? area : maxArea;
            if(height[low]<height[high]) low++;
            else high--;
        }
        return maxArea;
    }
    public int findMin(int x,int y){
        return (x<y) ? x : y;
    }
}
