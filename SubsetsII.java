/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
*/ 
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums); // crucial step to remove repeated subsets

        helper(nums, 0, sub, res);
        return res;
    }

    private void helper(int[] nums,int index, List<Integer> sub, List<List<Integer>> res){
        if(index >= nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        helper(nums, index + 1, sub, res);
        sub.remove(sub.size() - 1);
        int temp = nums[index];
        while(index < nums.length && nums[index] == temp)
            index++;
        helper(nums, index, sub, res);
    }
}
