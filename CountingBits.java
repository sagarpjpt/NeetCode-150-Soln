/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
*/ 
class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i = 1;i < n+1; i++){
            int count = 0;
            int num = i;
            while(num > 0){
                if(num % 2 != 0) count++;
                num /= 2;
            }
            res[i] = count;
        }
        return res;
    }
}
