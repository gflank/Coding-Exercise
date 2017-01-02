// merge sort solution
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (lower > upper || nums.length == 0) {
            return 0;
        }
        
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return mergeCount(prefix, lower, upper, 0, nums.length);
    }
    
    private int mergeCount(long[] pre, int lower, int upper, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = mergeCount(pre, lower, upper, start, mid)
                    + mergeCount(pre, lower, upper, mid + 1, end);
        
        // copy space for merge sort
        long[] copySpace = new long[end - start + 1];
        int lowerFirstValid = mid + 1, upperFirstInvalid = mid + 1;
        int rightPos = mid + 1, copyPos = 0;
        for (int leftPos = start; leftPos <= mid; ++leftPos) {
            while (lowerFirstValid <= end && pre[lowerFirstValid] - pre[leftPos] < lower) ++lowerFirstValid;
            while (upperFirstInvalid <= end && pre[upperFirstInvalid] - pre[leftPos] <= upper) ++upperFirstInvalid;
            // now copy all smaller number in right half into copyspace
            while (rightPos <= end && pre[rightPos] < pre[leftPos]) copySpace[copyPos++] = pre[rightPos++];
            // copy current number in left part into copyspace
            copySpace[copyPos++] = pre[leftPos];
            count += upperFirstInvalid - lowerFirstValid;
        }
        
        // copy back the sorted numbers
        System.arraycopy(copySpace, 0, pre, start, copyPos);
        return count;
    }
}


// O(n^2) solution, TLE
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (lower > upper || nums.length == 0) {
            return 0;
        }
        
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                long curSum = prefix[j + 1] - prefix[i];
                if (curSum <= upper && curSum >= lower) {
                    ++count;
                }
            }
        }
        return count;
    }
}