class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        int product = 1,zerocount = 0,pos=-1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0) {
                zerocount++;
                if(zerocount > 1) return answer;
                pos = i;
                continue;
            }
            product *= nums[i];
        }
        if(pos != -1){
            answer[pos] = product;
            return answer;
        }
        for(int i = 0;i<nums.length;i++){
            answer[i] = product / nums[i];
        }
        return answer;
    }
}
