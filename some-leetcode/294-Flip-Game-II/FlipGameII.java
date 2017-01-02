public class Solution {
    public boolean canWin(String s) {
        int len = s.length();
        if (len == 0) {
            return false;
        }
        
        // store the string into char array
        char[] in = new char[len];
        for (int i = 0; i < len; ++i) {
            in[i] = s.charAt(i);
        }
        
        return judge(in);
    }
    
    private boolean judge(char[] in) {
        for (int i = 0; i < in.length - 1; ++i) {
            if (in[i] == '+' && in[i + 1] == '+') {
                in[i] = '-';
                in[i + 1] = '-';
                boolean opponent = judge(in);
                // should change back the array befor return
                in[i] = '+';
                in[i + 1] = '+';
                if (opponent == false) {
                    return true;
                }
            }
        }
        
        return false;
    }
}