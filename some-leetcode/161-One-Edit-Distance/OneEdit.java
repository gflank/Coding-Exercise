
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS + lenT == 0) {
            return false;
        }
        if (lenS + lenT == 1) {
            return true;
        }
        else if (Math.abs(lenS - lenT) > 1) {
            return false;
        }
        
        // flag, 0 means not detect, 1 detected such pattern, 2 confirmed it is impossible
        int modify = 0, delete = 0;
        int posS = 0, posT = 0;
        boolean equal = true;
        
        while (posS != lenS && posT != lenT) {
            if (s.charAt(posS) != t.charAt(posT)) {
                equal = false;
                // if length is the same, then must be modified
                if (lenS == lenT) {
                    ++modify;
                    ++posS;
                    ++posT;
                }
                // if length is different, must be deleted or inserted
                else {
                    ++delete;
                    // move the longer one
                    if (lenS > lenT) {
                        ++posS;
                    }
                    else {
                        ++posT;
                    }
                }
                // detect violation
                if (modify > 1 || delete > 1) {
                    return false;
                }
                
                continue;
            }
            
            // increase indexes and continue loop
            ++posT;
            ++posS;
        }
        
        // if equal, false
        if (equal && (lenS == lenT)) {
            return false;
        }
        
        return true;
    }
}
