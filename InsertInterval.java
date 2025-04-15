/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/ 
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s = newInterval[0];
        int e = newInterval[1];
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        //add all intervals before new interval
        while (i < n && intervals[i][1] < s){
            result.add(intervals[i]);
            i++;
        }

        //merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= e){
            s = Math.min(s, intervals[i][0]);
            e = Math.max(e, intervals[i][1]);
            i++;
        }
        result.add(new int[]{s, e}); //add the merged interval

        //addd all the remaining intervals
        while (i < n){
            result.add(intervals[i]);
            i++;
        }
        //convert the List<int[]> ---> int[][]
        return result.toArray(new int[result.size()][]);
    }
}
