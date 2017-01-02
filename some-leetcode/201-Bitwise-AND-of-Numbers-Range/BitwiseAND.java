public class Solution {
    // wrong answer
    // public int rangeBitwiseAnd(int m, int n) {
    //     long base = 1;
    //     while ((long)m >= base) {
    //         base *= 2;
    //     }
        
    //     if ((long)n >= base) {
    //         return 0;
    //     }
    //     else {
    //         return (int)(base / 2);
    //     }
    // }
    
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {
            mask = mask << 1;
        }
        
        return mask & m;
    }
}