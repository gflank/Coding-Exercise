// rewrote version
public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows <= 1) {
            return s;
        }
        
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            res[i] = new StringBuilder();
        }
        int pos = 0;
        while (pos < s.length()) {
            for (int i = 0; i < numRows & pos < s.length(); ++i) {
                res[i].append(s.charAt(pos));
                ++pos;
            }
            for (int i = numRows - 2; i > 0 & pos < s.length(); --i) {
                res[i].append(s.charAt(pos));
                ++pos;
            }
        }
        for (int i = 1; i < numRows; ++i) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}

// unneat version
// public class Solution {
//     public String convert(String s, int numRows) {
//         if (s.length() == 0 || numRows <= 1) {
//             return s;
//         }
//         int numCols = s.length() / (numRows - 2 + numRows) * 2;
//         if (numCols / 2 * (numRows - 2 + numRows) + numRows >= s.length()) {
//             numCols += 1;
//         }
//         else {
//             numCols += 2;
//         }
        
//         char[][] chars = new char[numRows][numCols];
//         int pos = 0;
//         for (int col = 0; col < numCols & pos < s.length(); ++col) {
//             if (col % 2 == 0) {
//                 for (int row = 0; row < numRows && pos < s.length(); ++row) {
//                     chars[row][col] = s.charAt(pos);
//                     ++pos;
//                 }
//             }
//             else {
//                 for (int row = numRows - 2; row > 0 && pos < s.length(); --row) {
//                     chars[row][col] = s.charAt(pos);
//                     ++pos;
//                 }
//             }
//         }
        
//         // now construct the string
//         pos = 0;
//         StringBuilder res = new StringBuilder();
//         for (int row = 0; row < numRows & pos < s.length(); ++row) {
//             for (int col = 0; col < numCols & pos < s.length(); ++col) {
//                 if (chars[row][col] != '\u0000') {
//                     res.append(chars[row][col]);
//                     ++pos;
//                 }
//             }
//         }
//         return res.toString();
//     }
// }