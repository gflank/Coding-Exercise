// fast version using array
public class Solution {
    private int count;
    private char[][] pairs = {{'1', '1'}, {'8', '8'}, {'0', '0'}, {'9', '6'}, {'6', '9'}};
    
    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        for (int len = low.length(); len <= high.length(); ++len) {
            backtracking(0, len - 1, new char[len], low, high);
        }
        return count;
    }
    
    private void backtracking(int left, int right, char[] num, String low, String high) {
        // if surpass half
        if (left > right) {
            // if invalid, dont count
            String cur = new String(num);
            if ((num.length == low.length() && cur.compareTo(low) < 0) || (num.length == high.length() && cur.compareTo(high) > 0)) {
                return;
            }
            ++count;
            return;
        }
        
        for (char[] pair : pairs) {
            num[left]  = pair[0];
            num[right] = pair[1];
            // 0 at head is invalid
            if (num.length != 1 && num[0] == '0') continue;
            // omit when 6 or 9 at middle
            if (left < right || left == right && pair[0] == pair[1]) backtracking(left + 1, right - 1, num, low, high);
        }
    }
}


// first accepted version, super slow
public class Solution {
    private int count;
    private char[] candidates = {'0', '1', '6', '8', '9'};
    
    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        for (int i = low.length(); i <= high.length(); ++i) {
            backtracking(i, 0, new StringBuilder(), low, high);
        }
        return count;
    }
    
    private void backtracking(int len, int pos, StringBuilder path, String low, String high) {
        // if surpass half
        if (pos >= (len + 1) / 2) {
            // 6, 9 in middle invalid
            if (len % 2 == 1 && (path.charAt(pos - 1) == '6' || path.charAt(pos - 1) == '9')) return;
            StringBuilder curPath = new StringBuilder(path.toString());
            for (int i = len / 2 - 1; i >= 0; --i) {
                curPath.append(getPair(curPath.charAt(i)));
            }
            String cur = curPath.toString();
            // if invalid, dont count
            if ((len == low.length() && cur.compareTo(low) < 0) || (len == high.length() && cur.compareTo(high) > 0)) {
                return;
            }
            ++count;
            return;
        }
        
        for (char c : candidates) {
            // 0 at head invalid if len != 1
            if (pos == 0 && c == '0' && len != 1) continue;
            path.append(c);
            backtracking(len, pos + 1, path, low, high);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    private char getPair(char c) {
        if (c == '1' || c == '8' || c == '0') {
            return c;
        }
        if (c == '6') {
            return '9';
        }
        return '6';
    }
}