import java.util.*;

public class FourIntegers {
	public static int[] four(int A, int B, int C, int D) {
		int[] res = new int[4];
		res[0] = A;
		res[1] = B;
		res[2] = C;
		res[3] = D;
		Arrays.sort(res);
		// make the sequence into 2, 0, 3, 1
		swap(res, 2, 3);
		swap(res, 1, 3);
		swap(res, 0, 1);
		return res;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] =temp;
	}
}