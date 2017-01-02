public class NumArray {
    int [] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return prefixSum[j];
        }
        else {
            return prefixSum[j] - prefixSum[i - 1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
