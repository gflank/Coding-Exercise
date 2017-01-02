
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        
        int begin = 1, end = n;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (isBadVersion(mid) == true) {
                end = mid;
            }
            else {
                begin = mid;
            }
        }
        
        if (isBadVersion(begin) == true) {
            return begin;
        }
        else if (isBadVersion(end) == true) {
            return end;
        }
        
        return -1;
    }
}
