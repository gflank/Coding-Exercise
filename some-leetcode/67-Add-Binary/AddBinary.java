public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        
        int iA = lenA - 1;
        int iB = lenB - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (iA != -1 || iB != -1 || carry != 0) {
            int tmpA, tmpB;
            if (iA == -1) {
                tmpA = 0;
            }
            else {
                tmpA = a.charAt(iA) - '0';
                --iA;
            }
            if (iB == -1) {
                tmpB = 0;
            }
            else {
                tmpB = b.charAt(iB) - '0';
                --iB;
            }
            
            int tmpSum = tmpA + tmpB + carry;
            if (tmpSum >= 2) {
                carry = 1;
                tmpSum -= 2;
            }
            else {
                carry = 0;
            }
            
            sb.append(tmpSum);
        }
        
        return sb.reverse().toString();
    }
}