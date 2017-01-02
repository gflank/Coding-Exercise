// Sqrt(x) Total Accepted: 55116 Total Submissions: 238622 My Submissions Question Solution 
// Implement int sqrt(int x).

// Compute and return the square root of x.

// Hide Tags Math Binary Search

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 0) {
        	return -1;
        }

        if (x == 0) {
        	return 0;
        }
        else if (x == 1) {
        	return 1;
        }

        long start = 1, end = x / 2, mid;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (mid * mid >= x) {
        		end = mid;
        	}
        	else {
        		start = mid;
        	}
        }

        if (end * end <= x) {
        	return (int)end;
        }
        else {
        	return (int)start;
        }
    }

    public static void main(String[] args) {
    	Sqrt A = new Sqrt();
    	System.out.println(A.mySqrt(2147395599));
    }
}
