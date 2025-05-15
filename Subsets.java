/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/ 

/*
    in a recursion tree each level represent current index at array
    ie level 0 means index is at 0 in array and 2 child of it shows 
    wether value at that index present or absent in subset
    expand whole tree and all the subsets will be at leaf node 
    leaf node ----> index is at nums.length
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(nums, 0, subset, res);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> res){
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        helper(nums, index + 1, subset, res);
        subset.remove(subset.size() - 1);
        helper(nums, index + 1, subset, res);
    }
}
