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
