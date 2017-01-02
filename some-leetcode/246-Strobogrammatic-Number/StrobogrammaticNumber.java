public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0) {
            return true;
        }
        
        int head = 0;
        int tail = num.length() - 1;
        while (head < tail) {
            if (!match(num.charAt(head), num.charAt(tail))) {
                return false;
            }
            ++head;
            --tail;
        }
        if (head == tail) {
            if (num.charAt(head) != '0' && num.charAt(head) != '1' && num.charAt(head) != '8') {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean match(char c1, char c2) {
        if (c1 == '8' && c2 == '8') {
            return true;
        }
        if (c1 == '1' && c2 == '1') {
            return true;
        }
        if (c1 == '0' && c2 == '0') {
            return true;
        }
        if (c1 == '6' && c2 == '9') {
            return true;
        }
        if (c1 == '9' && c2 == '6') {
            return true;
        }
        return false;
    }
}