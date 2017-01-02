public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0 || lower > upper) {
            // handler the empty array case
            if (lower == upper) {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                res.add(sb.toString());
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                sb.append("->");
                sb.append(upper);
                res.add(sb.toString());
            }
            return res;
        }
        
        // first deal with the first number
        if (nums[0] == lower + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            res.add(sb.toString());
        }
        else if (nums[0] > lower + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            sb.append("->");
            sb.append(nums[0] - 1);
            res.add(sb.toString());
        }
        
        // now deal with the middle part
        for (int i = 1; i < nums.length; ++i) {
            // skip the continuous part
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }
            else if (nums[i] == nums[i - 1] + 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i] - 1);
                res.add(sb.toString());
            }
            else if (nums[i] > nums[i - 1] + 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i - 1] + 1);
                sb.append("->");
                sb.append(nums[i] - 1);
                res.add(sb.toString());
            }
        }
        
        // last handle the last number
        if (upper == nums[nums.length - 1] + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(upper);
            res.add(sb.toString());
        }
        else if (upper > nums[nums.length - 1] + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[nums.length - 1] + 1);
            sb.append("->");
            sb.append(upper);
            res.add(sb.toString());
        }
        
        return res;
    }
}