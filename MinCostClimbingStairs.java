/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
*/ 

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1]; // init with all 0 and dp[n] stores our res

        // we can start from either index 0 or 1
        for(int i = 2;i <= n;i++)
            dp[i] = Math.min( dp[i-1] + cost[i-1], dp[i-2] + cost[i-2] );
    
        return dp[n];
    }

    /*
        // brute force recursive way
    int minCost[] = new int[1];
    public int minCostClimbingStairs(int[] cost) {
        minCost[0] = Integer.MAX_VALUE;
        dp(cost, 0, 0);
        dp(cost, 1, 0);
        return minCost[0];
    }

    private void dp(int[] cost, int index, int cost_so_far){
        if(index == cost.length){
            minCost[0] = Math.min(cost_so_far, minCost[0]);
            return;
        }

        if(index < cost.length){
            dp(cost, index+1, cost[index] + cost_so_far);
            dp(cost, index+2, cost[index] + cost_so_far);
        }
    }
    
    */ 
    
}
