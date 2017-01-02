
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if (s.length() == 0 || s == null || s == "") {
            return res;
        }
        
        int len = s.length();
        int curLen = 0;
        for (int i = 0; i < len; ++i) {
            // extend two positions, left one right one
            if (isPal(s, i - curLen - 1, i)) {
                res = s.substring(i - curLen - 1, i + 1);
                curLen += 2;
            }
            // extend one position, right one
            else if (isPal(s, i - curLen, i)) {
                res = s.substring(i - curLen, i + 1);
                curLen += 1;
            }
        }
        
        return res;
    }
    
    private Boolean isPal(String s, int begin, int end) {
        if (begin < 0 || end >= s.length()) {
            return false;
        }
        for (int i = begin, j = end; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
}
