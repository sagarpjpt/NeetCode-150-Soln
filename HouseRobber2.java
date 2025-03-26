/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
*/

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(robHelp(nums, 0, len-2), robHelp(nums, 1, len-1));
    }

    private int robHelp(int[]n, int low, int high){
        int p1 = 0, p2 = 0;
        for (int i = low; i <= high;i++){
            int temp = Math.max(p1, p2 + n[i]);
            p2 = p1;
            p1 = temp;
        }
        return p1;
    }
}
