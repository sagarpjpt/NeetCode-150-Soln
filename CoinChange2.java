/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.
Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/ 

class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1]; // 2d matrix of row ---> coins and col ---> amount from 0 to amount inclusive
        
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++)
                dp[i][j] = -1;
        }

        return dfs(0, 0, amount, coins);
    }

    private int dfs(int index, int amount_so_far, int total, int[] coins){
        if(amount_so_far == total) return 1;
        if(amount_so_far > total || index == coins.length) return 0;
        if(dp[index][amount_so_far] != -1)  return dp[index][amount_so_far];

        // dp[][] = picking same coin again + skip the current coin
        dp[index][amount_so_far] = dfs(index, amount_so_far + coins[index], total, coins) + dfs(index + 1, amount_so_far, total, coins);
        return dp[index][amount_so_far];
    }
    
    /*
        // BRUTE FORCE
    int count;
    public int change(int amount, int[] coins) {
        count = 0;
        dfs(0, 0, amount, coins);
        return count;
    }

    private void dfs(int amount_so_far, int index, int total, int[] coins){
        if(amount_so_far == total) count++;
        if(amount_so_far > total) return;
        for(int i = index;i < coins.length;i++){
            dfs(amount_so_far + coins[i], i, total, coins);
        }
    }

    */ 
}
