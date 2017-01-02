// partition version
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        int mid = nums.length / 2;
        int midVal = findKth(nums, 0, nums.length - 1, mid + 1);
        
        // i -> larger part, j -> equal part, k -> smaller part
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[indexConvert(j, mid)] > midVal) {
                swap(nums, indexConvert(i++, mid), indexConvert(j++, mid));
            }
            else if (nums[indexConvert(j, mid)] < midVal) {
                swap(nums, indexConvert(j, mid), indexConvert(k--, mid));
            }
            else {
                ++j;
            }
        }
    }
    
    private int findKth(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int pos = start; // the larger part's begin
        
        for (int i = start; i < end; ++i) {
            if (nums[i] > pivot) {
                swap(nums, pos++, i);
            }
        }
        swap(nums, pos, end); //  put pivot in the middle
        
        int pivotPos = pos - start + 1; // relative position
        if (pivotPos == k) {
            return pivot;
        }
        else if (pivotPos > k) {
            return findKth(nums, start, pos - 1, k);
        }
        else {
            return findKth(nums, pos + 1, end, k - pivotPos);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int indexConvert(int ori, int mid) {
        if (ori >= mid) {
            return 2 * (ori - mid);
        }
        else {
            return 1 + 2 * (ori - 0);
        }
    }
}


// sorting version
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = (n % 2 == 0)? n/2-1 : n/2;
        int[] temp = Arrays.copyOf(nums, n);
        
        int index = 0;
        for (int i = 0; i <= mid; ++i) {
            nums[index] = temp[mid - i];
            if (index + 1 < n) {
                nums[index + 1] = temp[n - 1 - i];
            }
            index += 2;
        }
    }
}