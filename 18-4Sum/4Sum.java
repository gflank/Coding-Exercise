public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return res;
        }
        
        // sort the array first
        Arrays.sort(nums);
        
        for (int outer1 = 0; outer1 < nums.length - 3; ++outer1) {
            if (outer1 > 0) {
                // skip the duplicates
                if (nums[outer1] == nums[outer1 - 1]) {
                    continue;
                }
            }
            for (int outer2 = outer1 + 1; outer2 < nums.length - 2; ++outer2) {
                if (outer2 > outer1 + 1) {
                    // skip the duplicates
                    if (nums[outer2] == nums[outer2 - 1]) {
                        continue;
                    }
                }
                int head = outer2 + 1;
                int tail = nums.length - 1;
                while (head < tail) {
                    int tmpSum = nums[outer1] + nums[outer2] + nums[head] + nums[tail];
                    if (tmpSum == target) {
                        // create a new list for this solution
                        // add this solution to result
                        res.add(Arrays.asList(nums[outer1], nums[outer2], nums[head], nums[tail]));
                        
                        // skip duplicates
                        while (head < tail && nums[head] == nums[head + 1]) {
                            ++head;
                        }
                        while (head < tail && nums[tail] == nums[tail - 1]) {
                            --tail;
                        }
                        ++head;
                        --tail;
                        
                        // slower version, why? (just a little bit)
                        // // create a new list for this solution
                        // List<Integer> sol = new ArrayList<Integer>();
                        // sol.add(nums[outer1]);
                        // sol.add(nums[outer2]);
                        // sol.add(nums[head]);
                        // sol.add(nums[tail]);
                        // // add this solution to result
                        // res.add(sol);
                        
                        // // skip duplicates
                        // ++head;
                        // while (head < tail && nums[head] == nums[head - 1]) {
                        //     ++head;
                        // }
                        // --tail;
                        // while (head < tail && nums[tail] == nums[tail + 1]) {
                        //     --tail;
                        // }
                    }
                    else if (tmpSum < target) {
                        ++head;
                    }
                    else {
                        --tail;
                    }
                }
            }
        }
        
        return res;
    }
}