/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/ 
class Solution {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.value - a.value;  // Max-heap: bigger value first
            }
        });

        List<Integer> list = new ArrayList<>();

        int l =0, r =k-1;
        for(int i = l;i < r;i++)
            maxHeap.add(new Pair(nums[i], i));

        while(r < nums.length){
            maxHeap.add(new Pair(nums[r], r));
            while(true){
                Pair top = maxHeap.peek();
                if(top.index >= l){
                    list.add(top.value);
                    break;
                }
                else{
                    top = maxHeap.poll();
                }
            }
            l++;r++;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        return array;   
    }
}
