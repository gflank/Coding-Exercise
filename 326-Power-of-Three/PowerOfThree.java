public class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowOfThree = 1, prev = 0;
        while (maxPowOfThree > prev) {
            prev = maxPowOfThree;
            maxPowOfThree *= 3;
        }
        return (n > 0) && (prev % n == 0);
    }
}