import java.util.*;

public class SlidingMin {
	public int[] slidingMin(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
			return new int[0];
		}

		// Deque to store all the candidates' indices within window
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; ++i) {
			// start from kth element, poll out the outdated elements
			if (i >= k && deque.peekFirst() + k <= i) {
				deque.pollFirst();
			}
			// before put current element into queue, poll out all elements that is larger from the tail
			while (!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);

			// output the mins
			if (i >= k - 1) {
				res[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SlidingMin test = new SlidingMin();
		int[] nums = {4, 2, 12, 11, -5};
		int k = 2;
		int[] res = test.slidingMin(nums, k);
		for (int n : res) {
			System.out.println(n);
		}
	}
}