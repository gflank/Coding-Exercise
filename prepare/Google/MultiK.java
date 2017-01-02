import java.util.*;

public class MultiK {
	// assume input nums is valid -> nums.length >= k
	// not consider overflow
	public static int multiK(int[] nums, int k) {
		if (nums.length == k) {
			int res = 1;
			for (int n : nums) {
				res *= n;
			}
			return res;
		}

		// minHeap saves the k biggest numbers
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// maxHeap saves the k smallest numbers
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		int max = Integer.MIN_VALUE;
		for (int n : nums) {
			max = Math.max(max, n);
			// maintain minHeap and maxHeap both with k number
			minHeap.offer(n);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
			maxHeap.offer(n);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		int res = 1;
		// check special cases
		// if all negatives, and k is odd
		// result would be negative, choose from biggest k
		if (max < 0 && k % 2 == 1) {
			while (!minHeap.isEmpty()) {
				res *= minHeap.poll();
			}
			return res;
		}

		// otherwise the result would be >= 0
		// convert heaps to sorted list
		int[] minK = new int[k];
		int[] maxK = new int[k];
		for (int i = k - 1; i >= 0; --i) {
			minK[i] = maxHeap.poll();
			maxK[i] = minHeap.poll();
		}

		int minPos = 0, maxPos = 0;
		// if k is odd, poll the largest non-negative first 
		if (k % 2 == 1) {
			--k;
			res *= maxK[maxPos];
			++maxPos;
		}
		// now choose k/2 pairs out of heap
		while (k != 0) {
			int minPair = minK[minPos] * minK[minPos + 1];
			int maxPair = maxK[maxPos] * maxK[maxPos + 1];
			if (maxPair > minPair) {
				res *= maxPair;
				maxPos += 2;
			}
			else {
				res *= minPair;
				minPos += 2;
			}
			k -= 2;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] test1 = {-8, -7, -3, -1, 0, 5, 6, 9};
		int k = 3;
		System.out.println("test1: " + MultiK.multiK(test1, k));

		int[] test2 = {-8, -7, -3, -1, 0, 5, 6, 9};
		k = 2;
		System.out.println("test2: " + MultiK.multiK(test2, k));

		int[] test3 = {-8, -7, -3, -1};
		k = 3;
		System.out.println("test3: " + MultiK.multiK(test3, k));

		int[] test4 = {1, 2, 3, 5, 6, 9};
		k = 4;
		System.out.println("test4: " + MultiK.multiK(test4, k));

		int[] test5 = {-8, -7, -3, -1, 0, 5, 6, 9};
		k = 7;
		System.out.println("test5: " + MultiK.multiK(test5, k));
	}
}