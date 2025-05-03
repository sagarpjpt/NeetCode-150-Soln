/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
*/ 
class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // int i = 0;
        // for(i = 0;i < nums.length-1;i++){
        //     if(nums[i] == nums[i+1])
        //         break;
        // }
        // return nums[i];
        int res = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                res = num;
                break;
            }
            else
                map.put(num, 1);
        }
        return res;
    }
}
