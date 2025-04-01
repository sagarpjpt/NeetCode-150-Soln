/*
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/

class Solution {
    public int maxProduct(int[] nums) {
        
        int len = nums.length;
        int left_prod = 1;
        int right_prod = 1;
        int max_prod = nums[0];
        
        for(int i = 0;i < len;i++){

            //if any of leftprod or rightprod become 0 then update it to 1
            left_prod = (left_prod == 0) ? 1 : left_prod;
            right_prod = (right_prod == 0) ? 1 : right_prod;

            //from left subarray prod
            left_prod *= nums[i];

            //from right subarray prod
            right_prod *= nums[len-1-i];

            max_prod = Math.max(left_prod, Math.max(right_prod, max_prod));

        }
        return max_prod;
    }

        /*  BRUTE FORCE 
        if(nums.length == 1) return nums[0];
        
        //index i represent subarray of len i
        //dp[i] represent max product when subarray is of len i
        int dp[] = new int[nums.length+1];

        int len = dp.length;
        // for(int i = 1; i < len;i++)
        //     dp[i] = integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < len;i++){
            dp[i] = maxPro(i, nums);
            max = (max <= dp[i]) ? dp[i] : max;
        }
        return max;
    }
    private int maxPro(int wnd_size, int[] nums){
        int low = 0, high = wnd_size-1;
        int max = Integer.MIN_VALUE;
        while(high < nums.length){
            int res = 1;
            for(int i = low;i <= high;i++)
                res *= nums[i];
            max = (max <= res) ? res : max;
            low++;high++;
        }
        return max;
    }
    */
}
