class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h_map = new HashMap<>();
        int flag;
        for(int i = 0; i<nums.length;i++){
            flag = target - nums[i];
            if(h_map.containsKey(flag)){
                return new int[] {i, h_map.get(flag)};
            }
            h_map.put(nums[i],i);
        }
        return null;
    }
   
}
