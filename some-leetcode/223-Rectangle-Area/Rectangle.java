public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = C - A;
        int y1 = D - B;
        int x2 = G - E;
        int y2 = H - F;
        
        // calculate the total area
        int shape = x1 * y1 + x2 * y2;
        
        // calculate the overlap shape
        long x3 = (long)Math.min(C, G) - (long)Math.max(A, E);
        long y3 = (long)Math.min(D, H) - (long)Math.max(B, F);
        
        if (x3 > 0 && y3 > 0) {
            shape -= (int)x3 * (int)y3;            
        }
        
        return shape;
    }
}