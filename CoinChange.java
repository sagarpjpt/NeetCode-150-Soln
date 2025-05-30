/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;

        int[] dp = new int[amount + 1];
        //index i of array dp[] represent amount to make using coins
        //dp[i] represent min coins needed to make amount i

        for(int i = 1;i <= amount;i++){
            dp[i] = Integer.MAX_VALUE;

            //with each coin
            for(int coin : coins){
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
