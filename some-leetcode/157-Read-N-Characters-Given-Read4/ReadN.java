/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int offset = 0;

        while (offset < n) {
            char[] buf4 = new char[4];
            int ret = read4(buf4);
            for (int i = 0; i < ret && offset < n; ++i) {
                buf[offset] = buf4[i];
                ++offset;
            }
            
            if (ret < 4) {
                break;
            }
        }
        
        return offset;
    }
}