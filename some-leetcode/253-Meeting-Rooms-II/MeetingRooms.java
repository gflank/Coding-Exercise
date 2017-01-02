public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        int[] starts = new int[intervals.length];
        int[] ends   = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; ++i) {
            starts[i] = intervals[i].start;
            ends[i]   = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int sPos = 0, ePos = 0;
        int max = 0, count = 0;
        while (sPos < intervals.length && ePos < intervals.length) {
            if (starts[sPos] < ends[ePos]) {
                ++count;
                ++sPos;
                max = Math.max(max, count);
            }
            else {
                --count;
                ++ePos;
            }
        }
        
        return max;
    }
}


// public class Solution {
//     public int minMeetingRooms(Interval[] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return 0;
//         }
//         int[] begin = new int[intervals.length];
//         int[] end = new int[intervals.length];
        
//         for (int i = 0; i < intervals.length; ++i) {
//             begin[i] = intervals[i].start;
//             end[i] = intervals[i].end;
//         }
        
//         Arrays.sort(begin);
//         Arrays.sort(end);
        
//         int beginPos = 0, endPos = 0, max = 0, count = 0;
        
//         while (beginPos < intervals.length && endPos < intervals.length) {
//             if (begin[beginPos] < end[endPos]) {
//                 ++count;
//                 ++beginPos;
//             }
//             else {
//                 --count;
//                 ++endPos;
//             }
//             if (count > max)
//                 max = count;
//         }
        
//         return max;
//     }
// }
