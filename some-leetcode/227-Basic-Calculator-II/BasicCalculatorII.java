// non stack solution
public class Solution {
    public int calculate(String s) {
        int res = 0, localRes = 0;
        char prevSign = '+';
        int pos = 0, len = s.length();
        while (pos < len) {
            // skip spaces
            if (s.charAt(pos) == ' ') {
                ++pos;
                continue;
            }
            // now should meet number
            int curNum = s.charAt(pos) - '0';
            ++pos;
            while (pos < len && Character.isDigit(s.charAt(pos))) {
                curNum = curNum * 10 + (s.charAt(pos++) - '0');
            }
            
            // now do calculation based on the sign
            if (prevSign == '+') {
                // update gloabal res first
                res += localRes;
                // replace local res
                localRes = curNum;
            }
            else if (prevSign == '-') {
                res += localRes;
                localRes = -curNum;
            }
            else if (prevSign == '*') {
                localRes *= curNum;
            }
            else if (prevSign == '/') {
                localRes /= curNum;
            }
            
            // skip spaces again
            while (pos < len && s.charAt(pos) == ' ') {
                ++pos;
            }
            // save next sign
            if (pos < len) {
                prevSign = s.charAt(pos++);
            }
        }
        res += localRes;
        return res;
    }
}