

// O(kn) version
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglys = new int[n];
        int[] indice = new int[primes.length];
        uglys[0] = 1;
        for (int i = 1; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; ++j) {
                min = Math.min(uglys[indice[j]] * primes[j], min);
            }
            uglys[i] = min;
            for (int j = 0; j < primes.length; ++j) {
                if (min == uglys[indice[j]] * primes[j]) {
                    indice[j] += 1;
                }
            }
        }
        return uglys[n - 1];
    }
}