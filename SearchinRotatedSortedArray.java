class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        return binSearch(nums, low, high, target);
    }
    public int binSearch(int nums[], int low, int high, int target){
        //step 1 take an eg. and keep on dividing array
        //when problem is small 
        if(low == high) return (target == nums[low]) ? low : -1;
        if(low+1 == high){
            if(target == nums[low]) return low;
            else if(target == nums[high]) return high;
            else return -1;
        }
        //when problem is big
        int mid = low + (high - low)/2;
        int left = binSearch(nums,low,mid,target);//left subtree return value
        int right = binSearch(nums,mid+1,high,target);//right subtree return value
        return (left>right) ? left : right;
    }
}
