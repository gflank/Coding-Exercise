/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        // add all the intervals with end time earlier than the start time of newInterval
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            ++i;
        }
        
        int newStart = newInterval.start, newEnd = newInterval.end;
        // merge all the related intervals
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newStart = Math.min(newStart, intervals.get(i).start);
            newEnd = Math.max(newEnd, intervals.get(i).end);
            ++i;
        }
        // add the merged interval
        res.add(new Interval(newStart, newEnd));
        // add all the rest
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            ++i;
        }
        return res;
    }
}