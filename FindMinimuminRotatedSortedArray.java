class Solution {
    public int findMin(int[] nums) {
        int low = 0,high = nums.length-1;
        return binSearch(nums,low,high);
    }
    public int binSearch(int nums[],int low,int high){
        if(low == high) return nums[low];
        if(low+1 == high) return (nums[low]<nums[high]) ? nums[low] : nums[high];
        int mid = low + (high - low) / 2; // note low + high and then divide by 2 can cause integer overflow 
        int minLeft= binSearch(nums,low,mid);
        int minRight = binSearch(nums,mid+1,high);
        return (minLeft<minRight) ? minLeft : minRight;
    }
}
