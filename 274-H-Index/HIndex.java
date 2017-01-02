// faster version
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] nums = new int[len + 1];
        
        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] >= len) {
                nums[len]++;
            }
            else {
                nums[citations[i]]++;
            }
        }
        
        for (int i = len; i > 0; --i) {
            if (nums[i] >= i) {
                return i;
            }
            else {
                nums[i - 1] += nums[i];
            }
        }
        return 0;
    }
}

// sort version
// public class Solution {
//     public int hIndex(int[] citations) {
//         if (citations.length == 0) {
//             return 0;
//         }
        
//         int h = citations.length;
//         Arrays.sort(citations);
//         for (int i = 0; i < citations.length; ++i) {
//             if (citations[i] >= h) {
//                 return h;
//             }
//             else {
//                 --h;
//             }
//         }
//         return 0;
//     }
// }