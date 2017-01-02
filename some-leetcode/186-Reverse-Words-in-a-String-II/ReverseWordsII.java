
public class Solution {
    /*
    // miss understood the problem...
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        int curPos = 0, len = s.length;
        for (int i = 0; i < len; ++i) {
            // once detect space, reverse the word before
            if (s[i] == ' ') {
                int begin = curPos, end = i - 1;
                while (begin < end) {
                    char temp = s[begin];
                    s[begin] = s[end];
                    s[end] = temp;
                    ++begin;
                    --end;
                }
                curPos = i + 1;
            }
        }
    }
    */

    /*
    // slow version
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        int len = s.length;        
        
        Boolean noSpace = true;
        // check if the space exist first
        for (int i = 0; i < len; ++i) {
            if (s[i] == ' ') {
                noSpace = false;
                break;
            }
        }
        
        // no need to continue if just one word
        if (noSpace) {
            return;
        }

        // reverse the string first
        for (int i = 0, j = len - 1; i < len / 2; ++i, --j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        
        // reverse every word in the reversed string
        int curPos = 0;
        for (int i = 0; i < len; ++i) {
            // once detect space or reach the end, reverse the word before
            if (s[i] == ' ' || i == len - 1) {
                int begin = curPos, end;
                // if reach the end, end should be current position
                if (i == len - 1) {
                    end = i;
                }
                else {
                    end = i - 1;
                }
                while (begin < end) {
                    char temp = s[begin];
                    s[begin] = s[end];
                    s[end] = temp;
                    ++begin;
                    --end;
                }
                curPos = i + 1;
            }
        }
    }
    */

    // this version doesn't check space before
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        int len = s.length;        

        // reverse the string first
        for (int i = 0, j = len - 1; i < len / 2; ++i, --j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        
        // reverse every word in the reversed string
        int curPos = 0;
        for (int i = 0; i < len; ++i) {
            // once detect space or reach the end, reverse the word before
            if (s[i] == ' ' || i == len - 1) {
                int begin = curPos, end;
                // if reach the end, end should be current position
                if (i == len - 1) {
                    end = i;
                }
                else {
                    end = i - 1;
                }
                while (begin < end) {
                    char temp = s[begin];
                    s[begin] = s[end];
                    s[end] = temp;
                    ++begin;
                    --end;
                }
                curPos = i + 1;
            }
        }
    }
}
