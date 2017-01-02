// start from the beginning
// public class Solution {
//     public int lengthOfLastWord(String s) {
//         if (s.length() == 0) {
//             return 0;
//         }
        
//         int count = 0;
//         boolean spaceFlag = false;
//         for (int i = 0; i < s.length(); ++i) {
//             if (s.charAt(i) == ' ') {
//                 spaceFlag = true;
//             }
//             else {
//                 if (spaceFlag) {
//                     spaceFlag = false;
//                     count = 0;
//                 }
//                 ++count;
//             }
//         }
        
//         return count;
//     }
// }

// start from the end
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean spaceFlag = false;
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            --tail;
        }
        for (int i = tail; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ++count;
            }
            else {
                break;
            }
        }
        
        return count;
    }
}