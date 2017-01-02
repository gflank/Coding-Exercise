
public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
    	long nLong = n;
    	long base = 1;
    	while (true) {
    		if (nLong == base) {
    			return true;
    		}
    		else if (base > nLong) {
    			return false;
    		}
    		base = base << 1;
    	}
    }

    public static void main(String[] args) {
    	PowerTwo A = new PowerTwo();
    	System.out.println(A.isPowerOfTwo(1));
    }
}
