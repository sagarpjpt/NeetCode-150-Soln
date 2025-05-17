/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
*/ 

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        helper(nums,res, sub);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> sub){
        if(sub.size() == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!sub.contains(nums[i])){
                sub.add(nums[i]);
                helper(nums, res, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
