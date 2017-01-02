//O(N^2) version
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        // sort the array first, O(NlgN)
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    count += hi - lo;
                    ++lo;
                }
                else {
                    --hi;
                }
            }
        }
        
        return count;
    }
}

// O(N^3) version
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        // sort the array first, O(NlgN)
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        ++count;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}