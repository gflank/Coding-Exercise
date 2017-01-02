
public class NumberOf1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; ++i) {
        	if ((n & 1) == 1) {
        		++count;
        	}
        	n  = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
    	NumberOf1 A = new NumberOf1();
    	// System.out.println("count: " + A.hammingWeight(-2147483647));
    	System.out.println("count: " + A.hammingWeight(Integer.MIN_VALUE + 1));
    }
}
