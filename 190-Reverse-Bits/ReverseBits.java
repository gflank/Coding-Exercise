// dumb version
// public class ReverseBits {
//     // you need treat n as an unsigned value
//     public int reverseBits(int n) {
//         int[] bits = new int[32];
        
//         // get all bits
//         int mask = 1;
//         for (int i = 0; i < 32; ++i) {
//             if (checkBit(mask, n)) {
//                 bits[i] = 1;
//             }
//             mask = mask << 1;
//         }
        
//         // now calculate the reverse number
//         int res = 0;
//         for (int i = 0; i < 32; ++i) {
//             res = res * 2 + bits[i];
//         }
//         return res;
//     }

//     private boolean checkBit(int num1, int num2) {
//         int tmp = num1 & num2;
//         return tmp != 0;
//     }

//     public static void main(String[] agrs) {
//         int n = 43261596;
//         ReverseBits test = new ReverseBits();
//         System.out.println(test.reverseBits(n));
//     }
// }

// one scan version
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // get all bits & calculate the res
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            res *= 2;
            if (checkBit(mask, n)) {
                ++res;
            }
            mask = mask << 1;
        }
        
        return res;
    }

    private boolean checkBit(int num1, int num2) {
        int tmp = num1 & num2;
        return tmp != 0;
    }

    public static void main(String[] agrs) {
        int n = 43261596;
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits(n));
    }
}
