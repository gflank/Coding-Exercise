
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.equals("") || str.length() == 0) {
            return 0;
        }

        int pos = 0;
        int len = str.length();
        boolean flag = false;
        
        // remove all the white space before number
        while (pos < len && str.charAt(pos) == ' ') {
            ++pos;
        }
        
        int sign = 1;
        // detect whether there is a sign bit
        if (pos < len && (str.charAt(pos) == '-' || str.charAt(pos) ==  '+')) {
            if (str.charAt(pos) == '-') {
                sign = -1;
            }
            ++pos;
        }

        long result = 0;
        int temp;
        
        // start to convert the number
        while (pos < len && isNumber(str.charAt(pos))) {
            // set the flag indicates there is at lease one number
            flag = true;
            temp = str.charAt(pos) - '0';
            result = result * 10 + temp;
            // filter the number if it exceeds the int range
            if (result >= Integer.MAX_VALUE && sign == 1) {
                return Integer.MAX_VALUE;
            }
            // notice that the negative max value is diffrent from the positive one
            if (result > Integer.MAX_VALUE && sign == -1) {
                return Integer.MIN_VALUE;
            }
            ++pos;
        }

        // check if the input contains number
        if (flag) {
            return sign * (int)result;
        }
        else {
            return 0;
        }
    }

    // helper function to judge if a bit is number, O(1)
    private boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        else {
            return false;
        }
    }
}
