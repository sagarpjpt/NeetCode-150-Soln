/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/

class Solution {
    public int rob(int[] nums) {
        //solution using DP memoization approach

        if(nums.length < 2) return nums[0];

        int[] total_loot = new int[nums.length];

        //memoize max loot at first 2 indexes
        //total_loot[i] represents the max sum of loot till house i
        total_loot[0] = nums[0];
        total_loot[1] = Math.max(nums[0], nums[1]);

        // filling remaining total loot
        for(int i = 2; i < nums.length; i++)
            //core logic
            total_loot[i] = Math.max(total_loot[i-2] + nums[i], total_loot[i-1]);

        return total_loot[nums.length-1];
    }
}
