// using lambda expression
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        
        // sort the intervals in ascending order based on start time
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}

// public class Solution {
//     // public boolean canAttendMeetings(Interval[] intervals) {
//     //     if (intervals == null || intervals.length == 0) {
//     //         return true;
//     //     }
        
//     //     int[] starts = new int[intervals.length];
//     //     int[] ends = new int[intervals.length];
        
//     //     for (int i = 0; i < intervals.length; ++i) {
//     //         starts[i] = intervals[i].start;
//     //         ends[i] = intervals[i].end;
//     //     }
        
//     //     Arrays.sort(starts);
//     //     Arrays.sort(ends);
        
//     //     int startPos = 0, endPos = 0, count = 0;
        
//     //     while (startPos < intervals.length) {
//     //         if (starts[startPos] < ends[endPos]) {
//     //             ++count;
//     //             ++startPos;
//     //         }
//     //         else {
//     //             --count;
//     //             ++endPos;
//     //         }
//     //         if (count > 1) {
//     //             return false;
//     //         }
//     //     }
        
//     //     return true;
//     // }

//     public boolean canAttendMeetings(Interval[] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return true;
//         }

//     	Arrays.sort(intervals, new Comparator<Interval>() {
//     		public int compare(Interval interval1, Interval interval2){
//     			return interval1.start - interval2.start;
//     		}
//     	});

//     	for (int i = 1; i < intervals.length; ++i) {
//     		if (intervals[i].start < intervals[i - 1].end) {
//     			return false;
//     		}
//     	}

//     	return true;
// 	}
// }
