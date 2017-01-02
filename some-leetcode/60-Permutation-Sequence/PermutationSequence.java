public class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        
        // create the factorials array and the number pool
        int[] facs = new int[n - 1];
        facs[0] = 1;
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        for (int i = 1; i < n - 1; ++i) {
            facs[i] = facs[i - 1] * (i + 1);
            nums.add(i + 1);
        }
        nums.add(n);
        
        StringBuilder res = new StringBuilder();
        for (int i = n - 2; i >= 0; i --) {
            // calculate how many number we want to skip
            int skip = (k - 1) / facs[i];
            // subtract the k indicating the new ranking
            k -= skip * facs[i];
            // append the new number and remove it from the pool
            res.append(nums.get(skip));
            nums.remove(skip);
        }
        // add the last number
        res.append(nums.get(0));
        
        return res.toString();
    }
}

// TLE
// public class Solution {
//     private int globalCount = 0;
    
//     public String getPermutation(int n, int k) {
//         if (n == 0 || k == 0) {
//             return "";
//         }
        
//         // array to mark whether this number is in path
//         boolean[] nums = new boolean[n];
//         // list to store path
//         List<Integer> path = new ArrayList<>();
//         return dfs(nums, k, path);
//     }
    
//     private String dfs(boolean[] nums, int k, List<Integer> path) {
//         // if reach the end
//         if (path.size() == nums.length) {
//             ++globalCount;
//             // if reach the kth permutation, return result
//             if (globalCount == k) {
//                 StringBuilder res = new StringBuilder();
//                 for (int num : path) {
//                     res.append(num);
//                 }
//                 return res.toString();
//             }
//         }
        
//         for (int i = 0; i < nums.length; ++i) {
//             if (!nums[i]) {
//                 // add to path and mark as in path
//                 path.add(i + 1);
//                 nums[i] = true;
//                 String tempRes = dfs(nums, k, path);
//                 if (!tempRes.equals("")) {
//                     return tempRes;
//                 }
//                 // remove from path and mark as not in path
//                 path.remove(path.size() - 1);
//                 nums[i] = false;
//             }
//         }
//         return "";
//     }
// }