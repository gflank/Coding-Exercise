// O(N) version
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        for (int i = 1; i < nums.length; ++i) {
            // odd index should be larger
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            // even index should be smaller
            else if (i != 0 && i % 2 == 0) {
                if (nums[i - 1] < nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}


// sort version
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            int temp =nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }
        
        return;
    }
}
