import java.util.*;

public class GrayCode {
	public static int grayCode(byte code1, byte code2) {
		byte xor = (byte)(code1 ^ code2);
		int count = 0;
		while (xor != 0) {
			xor = (byte)(xor & (xor - 1));
			++count;
		}
		if (count == 1) {
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		byte code1 = 0x01;
		byte code2 = 0x02;
		System.out.println(GrayCode.grayCode(code1, code2));
	}
}