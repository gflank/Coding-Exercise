public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; ++i) {
            int min = Math.min(Math.min(uglys[i2] * 2, uglys[i3] * 3), uglys[i5] * 5);
            uglys[i] = min;
            if (uglys[i2] * 2 == min) {
                ++i2;
            }
            if (uglys[i3] * 3 == min) {
                ++i3;
            }
            if (uglys[i5] * 5 == min) {
                ++i5;
            }
        }
        return uglys[n - 1];
    }
}