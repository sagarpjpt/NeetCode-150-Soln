/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.
Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
*/ 
class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];

        // [1 2 3 4] -----> 1 [1 2 3 4] 1

        arr[0] = 1;
        arr[arr.length-1] = 1;

        for(int i = 1;i < arr.length-1;i++)
            arr[i] = nums[i - 1];
    
        dp = new int[arr.length][arr.length];

        return dfs(1, arr.length - 2, arr);
    }

    private int dfs(int left, int right, int[] arr){
        if(left > right) return 0;

        if(dp[left][right] != 0) return dp[left][right];

        for(int i = left; i <= right;i++){
            int coins = arr[left-1] * arr[i] * arr[right + 1];
            coins += dfs(left, i - 1, arr) + dfs(i + 1, right, arr);
            dp[left][right] = Math.max(dp[left][right], coins);
        }

        return dp[left][right];
    }
}
