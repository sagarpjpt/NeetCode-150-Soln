/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[ [1,1,6], [1,2,5], [1,7], [2,6] ]
*/ 

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cnd = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates, 0, cnd, res, target);
        return res;
    }

    private void helper(int[] nums, int i, List<Integer> sub, List<List<Integer>> res, int target){
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        else if(i < nums.length && target > 0){
            sub.add(nums[i]);
            
            helper(nums, i + 1, sub, res, target - nums[i]);
            sub.remove(sub.size() - 1);
            
            //moving index to the element which is not in sub list
            //it removes problem of duplicating sets in res list
            // but 1st sort the candidates in order to do so
            int temp = nums[i];
            while(i < nums.length && nums[i] == temp) i++; 
            
            helper(nums, i, sub, res, target);
        }
    }
}





