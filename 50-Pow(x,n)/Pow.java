// Pow(x, n) Total Accepted: 53749 Total Submissions: 201424 My Submissions Question Solution 
// Implement pow(x, n).

// Hide Tags Math Binary Search

public class Pow {
    public double myPow(double x, int n) {
        if (n >= 0) {
        	return helper(x, n);
        }
        else {
        	return 1 / helper(x, n);
        }
    }

    private double helper(double x, int n) {
    	if (n == 0) {
    		return 1;
    	}
    	if (n == 1) {
    		return x;
    	}

    	double temp = helper(x, n / 2);
    	if (n % 2 == 0) {
    		return temp * temp;
    	}
    	else {
    		return temp * temp * x;
    	}
    }
}
