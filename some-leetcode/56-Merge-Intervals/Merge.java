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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        
        int[] starts = new int[intervals.size()];
        int[] ends   = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); ++i) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res = new ArrayList<Interval>();
        
        int newStart = -1, newEnd = -1;
        int sPos = 0, ePos = 0, count = 0;
        while (sPos < intervals.size() && ePos < intervals.size()) {
            if (starts[sPos] <= ends[ePos]) {
                if (newStart == -1) {
                    newStart = starts[sPos];
                }
                ++count;
                ++sPos;
            }
            else {
                newEnd = ends[ePos];
                --count;
                ++ePos;
            }
            
            if (count == 0) {
                res.add(new Interval(newStart, newEnd));
                newStart = -1;
            }
        }
        res.add(new Interval(newStart, ends[intervals.size() - 1]));
        return res;
    }
}


// wrong answer
// public class Solution {
//     public List<Interval> merge(List<Interval> intervals) {
//         if (intervals.size() == 0) {
//             return intervals;
//         }
        
//         int[] starts = new int[intervals.size()];
//         int[] ends   = new int[intervals.size()];
//         for (int i = 0; i < intervals.size(); ++i) {
//             starts[i] = intervals.get(i).start;
//             ends[i] = intervals.get(i).end;
//         }
        
//         Arrays.sort(starts);
//         Arrays.sort(ends);
//         List<Interval> res = new ArrayList<Interval>();
        
//         int newStart = -1, newEnd = -1;
//         int sPos = 0, ePos = 0;
//         while (sPos < intervals.size() && ePos < intervals.size()) {
//             if (starts[sPos] <= ends[ePos]) {
//                 if (newStart == -1) {
//                     newStart = starts[sPos];
//                 }
//                 else if (newStart != -1 && newEnd != -1) {
//                     if (starts[sPos] > newEnd) {
//                         // now add the new interval
//                         res.add(new Interval(newStart, newEnd));
//                         // reset the variables
//                         newStart = starts[sPos];
//                         newEnd   = -1;
//                     }
//                 }
//                 sPos++;
//             }
//             else {
//                 newEnd = ends[ePos];
//                 ePos++;
//             }
//         }
//         res.add(new Interval(newStart, ends[intervals.size() - 1]));
//         return res;
//     }
// }