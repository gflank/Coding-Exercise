// neat version
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int prevOffset = 0;
    private int prevRet = 0;
    private char[] buf4 = new char[4];
     
    public int read(char[] buf, int n) {
        int offset = 0;
        while (offset < n) {
            if (prevOffset == 0) {
                prevRet = read4(buf4);
            }
            while (offset < n && prevOffset < prevRet) {
                buf[offset++] = buf4[prevOffset++];
            }
            if (prevOffset >= prevRet) {
                prevOffset = 0;
            }
            if (prevRet < 4) {
                break;
            }
        }
        return offset;
    }
}

// /* The read4 API is defined in the parent class Reader4.
//       int read4(char[] buf); */

// public class Solution extends Reader4 {
//     /**
//      * @param buf Destination buffer
//      * @param n   Maximum number of characters to read
//      * @return    The number of characters read
//      */
//     private char[] prev = null;
     
//     public int read(char[] buf, int n) {
//         int offset = 0;
//         if (prev != null) {
//             for (int i = 0; i < prev.length; ++i) {
//                 if (offset >= n) {
//                     char[] remain = new char[prev.length - i];
//                     for (int j = 0; j < prev.length - i; ++j) {
//                         remain[j] = prev[i + j];
//                     }
//                     prev = remain;
//                     return offset;
//                 }
                
//                 buf[offset] = prev[i];
//                 ++offset;
//             }
//         }
//         prev = null;
        
//         while (offset < n) {
//             char[] buf4 = new char[4];
//             int ret = read4(buf4);
//             for (int i = 0; i < ret; ++i) {
//                 if (offset >= n) {
//                     prev = new char[ret - i];
//                     for (int j = 0; j < ret - i; ++j) {
//                         prev[j] = buf4[i + j];
//                     }
//                     break;
//                 }
                
//                 buf[offset] = buf4[i];
//                 ++offset;
//             }
//             if (ret < 4) {
//                 break;
//             }
//         }
//         return offset;
//     }
// }