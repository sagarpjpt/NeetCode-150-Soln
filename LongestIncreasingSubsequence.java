/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/ 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int t[] = new int[nums.length];

        //start main pointer 
        for(int i = 1; i < nums.length; i++){

            //start second pointer 
            for(int j = 0;j < i; j++){
                if(nums[i] > nums[j])
                    if(t[j] + 1 > t[i])
                        t[i] = t[j] + 1;
            }
        }
        
        // finding max value
        int maxIndex = 0;
        for(int i = 0; i < t.length; i++)
            if(t[i] > t[maxIndex])
                maxIndex = i;

        return t[maxIndex] + 1;
    }
}
