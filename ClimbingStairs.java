/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

class Solution {
    public int climbStairs(int n) {
        int table[] = new int[n+1];
        return dp(n, table);
    }

    private int dp(int n, int[] t){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(t[n-1] == 0) t[n-1] = dp(n-1, t);
        if(n-2 < 0) t[n] = t[n-1];
        else if(t[n-2] == 0){
            t[n-2] = dp(n-2, t);
            t[n] = t[n-1] + t[n-2];
        }
        else t[n] = t[n-1] + t[n-2];
        return t[n];
    }
}
