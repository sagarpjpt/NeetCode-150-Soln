/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int seq_len = 1;
        for(int i = 0;i<nums.length-1;i++){
            int diff = nums[i+1] - nums[i];
            if(diff == 0) continue;
            if(diff == 1) seq_len++;
            else{
                list.add(seq_len);
                seq_len = 1;
            }
        }
        list.add(seq_len);
        return Collections.max(list);
    }
}
