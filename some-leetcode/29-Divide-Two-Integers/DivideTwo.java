// Divide Two Integers Total Accepted: 40317 Total Submissions: 268530 My Submissions Question Solution 
// Divide two integers without using multiplication, division and mod operator.

// If it is overflow, return MAX_INT.

// Hide Tags Math Binary Search

public class DivideTwo {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 && dividend >= 0) {
        	return Integer.MAX_VALUE;
        }
        if (divisor == 0 && dividend < 0) {
        	return Integer.MIN_VALUE;
        }
        if (dividend == 0) {
        	return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
        	return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
        	sign = -1;
        }

        int shift;
        int result = 0;
        long dlong = Math.abs((long)dividend);
        long slong = Math.abs((long)divisor);
        while (dlong >= slong) {
        	shift = 0;
        	while (dlong >= (slong << shift)) {
        		++shift;
        	}
        	result += (1 << (shift - 1));
        	dlong -= (slong << (shift - 1));
        }

        return sign * result;
    }

    public static void main(String[] args) {
    	DivideTwo A = new DivideTwo();
    	System.out.println(A.divide(-2147483648, -1));
    }
}
