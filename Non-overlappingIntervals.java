/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
*/ 
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int count = 0;
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            // if overlapping
            if(current[1] > intervals[i][0]){
                current[1] = Math.min(current[1], intervals[i][1]); //update the end to min to avoid overlap 
                count++;
            }
            else
                // no overlap so add current interval to ---> current and move to next
                current = intervals[i];
        }
        return count;
    }
}
