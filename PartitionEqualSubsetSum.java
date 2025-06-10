/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/ 

class Solution {
    public boolean canPartition(int[] nums) {
        // if sum of array is odd then no way to partition it in half 
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        // a set of sums for memoization
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);

        // our target is 
        int target = sum / 2;

        for(int i = nums.length - 1;i >= 0;i--){
            HashSet<Integer> nextDp = new HashSet<>();
            for(int t : dp){
                if(t + nums[i] == target) return true;
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }

        return false;
    }
}
