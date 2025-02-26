class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return null;
        Set<List<Integer>> mainList = new HashSet<>();
        //sort the array
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int target = nums[i];
            int low = i+1,high = nums.length-1;
            while(low<high){
                if(nums[low] + nums[high] == -target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(target);
                    subList.add(nums[low]);
                    subList.add(nums[high]);
                    mainList.add(subList);
                    low++;high--;
                }
                else if(nums[low] + nums[high] > -target) high--;
                else low++;
            }
        }
        return new ArrayList<>(mainList);
    }
}
