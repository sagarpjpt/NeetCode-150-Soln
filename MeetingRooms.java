/*
Meeting Rooms
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.
Example 1:
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation:
(0,30) and (5,10) will conflict
(0,30) and (15,20) will conflict

Example 2:
Input: intervals = [(5,8),(9,15)]
Output: true
Note:  (0,8),(8,10) is not considered a conflict at 8
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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        //sort the array basis on start_i
        intervals.sort(Comparator.comparingInt(i -> i.start));

        // boolean canAttend = false;
        Interval curr = intervals.get(0);

        for(int i = 1;i < intervals.size();i++){
            
            //meeting time overlaps
            if(curr.end > intervals.get(i).start)
                return false;
            curr = intervals.get(i);
            
        }
        return true;
    }
}
