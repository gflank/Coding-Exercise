// dumb version
// public class Solution {
//     public int[] plusOne(int[] digits) {
//         if (digits.length == 0) {
//             return new int[0];
//         }
        
//         List resList = new ArrayList<Integer>();
//         int carry = 1;
//         for (int i = digits.length - 1; i >= 0; --i) {
//             int tmp = carry + digits[i];
//             if (tmp > 9) {
//                 tmp -= 10;
//                 carry = 1;
//             }
//             else {
//                 carry = 0;
//             }
            
//             resList.add(tmp);
//         }
//         if (carry == 1) {
//             resList.add(carry);
//         }
        
//         int[] res = new int[resList.size()];
//         for (int i = resList.size() - 1; i >= 0; --i) {
//             res[resList.size() - 1 - i] = (int)resList.get(i);
//         }
        
//         return res;
//     }
// }

// smart version
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}