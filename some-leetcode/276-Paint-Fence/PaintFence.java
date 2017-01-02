public class Solution {
    // # repeat & # possibility version
    // public int numWays(int n, int k) {
    //     if (n == 0) {
    //         return 0;
    //     }
    //     else if (n == 1) {
    //         return k;
    //     }
        
    //     int[] possible = new int[n + 1];
    //     int[] repeat = new int[n + 2];
    //     possible[1] = k;
    //     possible[2] = k * k;
    //     repeat[1] = 0;
    //     repeat[2] = k;
    //     for (int i = 3; i <= n; ++i) {
    //         repeat[i] = possible[i - 1] - repeat[i - 1];
    //         possible[i] = repeat[i] * k + repeat[i - 1] * (k - 1);
    //     }
        
    //     return possible[n];
    // }

    // refined version
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return k;
        }
        
        int repeat = 0;
        int possible = k;
        for (int i = 2; i <= n; ++i) {
            int nextRepeat = possible - repeat;
            possible = (possible - repeat) * k + repeat * (k - 1);
            repeat = nextRepeat;
        }
        
        return possible;
    }
}