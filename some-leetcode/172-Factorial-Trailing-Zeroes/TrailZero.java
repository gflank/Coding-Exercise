
public class TrailZero {
    public int trailingZeroes(int n) {
    	int result = 0;
    	while (n >= 5) {
    		n /= 5;
    		result += n;
    	}

        return result;
    }

    public static void main(String[] args) {
    	TrailZero A = new TrailZero();
    	System.out.println(A.trailingZeroes(30));
    }
}
