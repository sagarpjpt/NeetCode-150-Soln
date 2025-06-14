/*
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
*/ 
class Solution {
    int dp[][];
    int totalSum; // to shilf the sum between [0, totalSum] for indexing 2D cache
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int num : nums) totalSum += num;
        dp = new int[nums.length][2 * totalSum + 1];
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < dp[0].length;j++)
                dp[i][j] = Integer.MIN_VALUE;
        }

        return dfs(0, 0, nums, target);
    }

    private int dfs(int index, int sum_so_far, int[] nums, int target){
        // base case
        if(index == nums.length)
            return sum_so_far == target ? 1 : 0;

        // checking branch already explored or not
        if(dp[index][sum_so_far + totalSum] != Integer.MIN_VALUE)
            return dp[index][sum_so_far + totalSum];

        // current num added
        int ways1 = dfs(index+1, sum_so_far + nums[index], nums, target);

        // current num subtracted
        int ways2 = dfs(index+1, sum_so_far - nums[index], nums, target);

        dp[index][sum_so_far + totalSum] = ways1 + ways2;
        return dp[index][sum_so_far + totalSum];
    }

    /*
        // BRUTE FORCE
    public int findTargetSumWays(int[] nums, int target) {
        
        return dfs(0, 0, nums, target);
    }

    private int dfs(int index, int sum_so_far, int[] nums, int target){
        // base case
        if(index == nums.length)
            return sum_so_far == target ? 1 : 0;

        // current num added
        int ways1 = dfs(index+1, sum_so_far + nums[index], nums, target);

        // current num subtracted
        int ways2 = dfs(index+1, sum_so_far - nums[index], nums, target);

        return ways1 + ways2;
    }
    
    */ 
}
