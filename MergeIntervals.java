/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/ 

class Solution {
    public int[][] merge(int[][] intervals){
        if (intervals.length == 0) return new int[0][0];

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            // if overlapping & merge
            if(current[1] >= intervals[i][0])
                current[1] = Math.max(current[1], intervals[i][1]); 
            else{
                // no overlap &add current and move to next
                result.add(current);
                current = intervals[i];
            }
        }

        //add the last interval
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
