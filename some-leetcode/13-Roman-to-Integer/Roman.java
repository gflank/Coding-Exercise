public class Solution {
    public int romanToInt(String s) {
        int res = convert(s.charAt(s.length() - 1));
        int prev = res;
        for (int i = s.length() - 2; i >= 0; --i) {
            int cur = convert(s.charAt(i));
            if (cur >= prev) {
                res += cur;
            }
            else {
                res -= cur;
            }
            prev = cur;
        }
        return res;
    }
    
    private int convert(char symbol) {
        int res = 0;
        if (symbol == 'I') {
            res = 1;
        }
        else if (symbol == 'V') {
            res = 5;
        }
        else if (symbol == 'X') {
            res = 10;
        }
        else if (symbol == 'L') {
            res = 50;
        }
        else if (symbol == 'C') {
            res = 100;
        }
        else if (symbol == 'D') {
            res = 500;
        }
        else if (symbol == 'M') {
            res = 1000;
        }
        return res;
    }
}