// merge sort version
public class Solution {
    private class NumDex {
        int value;
        int index;
        public NumDex(int val, int ind) {
            value = val;
            index = ind;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        int[] table = new int[nums.length];
        NumDex[] numDexs = new NumDex[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numDexs[i] = new NumDex(nums[i], i);
        }
        mergeCount(numDexs, 0, nums.length - 1, table);
        List<Integer> res = new ArrayList<>();
        for (int n : table) {
            res.add(n);
        }
        return res;
    }
    
    public void mergeCount(NumDex[] nums, int start, int end, int[] table) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeCount(nums, start, mid, table);
        mergeCount(nums, mid + 1, end, table);
        merge(nums, start, mid, end, table);
    }

    public void merge(NumDex[] nums, int start, int mid, int end, int[] table) {
        NumDex[] copySpace = new NumDex[end - start + 1];
        int left = start, right = mid + 1;
        for (int i = 0; i < copySpace.length; ++i) {
            if (right > end || left <= mid && nums[left].value <= nums[right].value) {
                table[nums[left].index] += right - mid - 1;
                copySpace[i] = nums[left++];
            }
            else {
                copySpace[i] = nums[right++];
            }
        }

        // copy back the sorted numbers
        for (int i = 0; i < copySpace.length; ++i) {
            nums[i + start] = copySpace[i];
        }
    }
}


// binary search version
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int index = findInsertPos(sorted, nums[i]);
            res.add(index);
            sorted.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
    
    // find the insertion index of n, list sorted in ascending order
    private int findInsertPos(List<Integer> sorted, int n) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < n) return end + 1;
        if (sorted.get(0) >= n) return 0; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < n) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        if (sorted.get(start) >= n ) return start;
        return end;
    }
}