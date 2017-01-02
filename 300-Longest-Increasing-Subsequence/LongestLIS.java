// more readable version, self implemented binary search
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> seq = new ArrayList<>();
        for (int n : nums) {
            int pos = getPos(seq, n);
            // if new number is smaller than the first number in list
            if (pos == -1) continue;
            // if seq is empty or current number is larger than the largest number in seq
            else if (pos == seq.size()) {
                seq.add(n);
            }
            // find correct position an replace previous value
            else {
                seq.set(pos, n);
            }
        }
        return seq.size();
    }
    
    private int getPos(List<Integer> seq, int newVal) {
        if (seq.size() == 0) return 0;
        if (newVal > seq.get(seq.size() - 1)) return seq.size();
        
        // do binary search
        int start = 0, end = seq.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (seq.get(mid) == newVal) {
                return mid;
            }
            else if (seq.get(mid) > newVal) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        if (seq.get(start) > newVal) return start;
        return end;
    }
}


// binary search version
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> seq = new ArrayList<>();
        for (int n : nums) {
            // if seq is empty or current number is larger than the largest number in seq
            if (seq.size() == 0 || seq.get(seq.size() - 1) < n) {
                seq.add(n);
            }
            // find correct position an replace previous value
            else {
                int pos = Collections.binarySearch(seq, n);
                if (pos < 0) {
                    // search would return pos = (-(insertion point) - 1)
                    seq.set(-pos - 1, n);
                }
            }
        }
        return seq.size();
    }
}


// O(n^2) DP version
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max + 1;
    }
}