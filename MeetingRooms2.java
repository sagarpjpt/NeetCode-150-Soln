/*
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.
Example 1:
Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)
*/ 

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)return 0;

        //sorting of intervals
        intervals.sort(Comparator.comparingInt(i -> i.start));

        //minHeap to track the earliest end time
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //addd the end time of the first meeting
        heap.add(intervals.get(0).end);

        for(int i = 1;i < intervals.size();i++){

            //if the current meeting starts after the earliest ended one
            if (intervals.get(i).start >= heap.peek()) 
                heap.poll(); //our day is free

            heap.add(intervals.get(i).end); // add end time of current meeintg
        }

        // heap size tells the number of days required
        return heap.size();
    }
}
