// Valid Number Total Accepted: 28301 Total Submissions: 248320 My Submissions Question Solution 
// Validate if a given string is numeric.

// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

// Hide Tags Math String

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean result = false;
        int pos = 0;
        int len = s.length();

        int frontFlag = 0;
        int eFlag = 0;
        while (pos < len && s.charAt(pos) == ' ') {
        	++pos;
        }
        if (pos < len && (s.charAt(pos) == '-' || s.charAt(pos) == '+')) {
        	++pos;
        }
        while(pos < len && isNumber(s.charAt(pos))) {
        	result = true;
        	frontFlag = 1;
        	++pos;
        }
        if (pos < len && s.charAt(pos) == '.') {
        	++pos;
        }
        while(pos < len && isNumber(s.charAt(pos))) {
        	result = true;
        	frontFlag = 1;
        	++pos;
        }
        if (pos < len && s.charAt(pos) == 'e') {
        	result = false;
        	eFlag = 1;
        	++pos;
        }
        if (pos < len && (s.charAt(pos) == '-' || s.charAt(pos) == '+')) {
        	if (eFlag == 0 && frontFlag == 1) {
        		return false;
        	}
        	++pos;
        }        
        while(pos < len && isNumber(s.charAt(pos))) {
        	if (frontFlag == 1) {
	        	result = true;
        	}
        	++pos;
        }
        while (pos < len && s.charAt(pos) == ' ') {
        	++pos;
        }

        return result && pos == len;
    }

    private boolean isNumber(char c) {
    	if (c >= '0' && c <= '9') {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public static void main(String[] args) {
    	ValidNumber A = new ValidNumber();
    	System.out.println(A.isNumber(".8+"));
    }
}
