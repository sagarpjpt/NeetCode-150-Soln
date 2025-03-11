class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
        the core logic is to explore all the combination leadig to achieve to target
        so we can pick each ele( or say index ) as many times so 
        for every index we will call recursively with two options either to pick 
        the element and not pick the ele
        with that in mind lets start coding :)
         */

        // list to store all valid combination 
        List<List<Integer>> result = new ArrayList<>();

        //recursively picking and not picking each index 
        recursively(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void recursively(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> res){

        //small(); cond.
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return ;
        }

        //iterating arr
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] <= target) {
                curr.add(candidates[i]);
                //adding curr i till get target 0 or not
                recursively(candidates, target - candidates[i], i, curr, res);
                //after backtrack remove last inserted index ele value
                curr.remove(curr.size() - 1);
            }
        }

    }
}
