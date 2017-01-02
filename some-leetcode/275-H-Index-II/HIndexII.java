public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        
        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= len - mid) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (citations[start] >= len - start) {
            return len - start;
        }
        else if (citations[end] >= len - end) {
            return len - end;
        }
        return 0;
    }
}