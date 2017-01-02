// Median of Two Sorted Arrays Total Accepted: 43948 Total Submissions: 246266 My Submissions Question Solution 
// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Hide Tags Divide and Conquer Array Binary Search

public class MedianOfTwo {
    public double findMedianSortedArrays(int A[], int B[]) {
        int num = A.length + B.length;
        if (num % 2 == 0) {
        	return (findKth(A, 0, B, 0, num / 2) + findKth(A, 0, B, 0, num / 2 + 1)) / 2.0;
        }
        else {
        	return findKth(A, 0, B, 0, num / 2 + 1);
        }
    }

    public double findKth(int A[], int startA, int B[], int startB, int k) {
    	if (startA >= A.length) {
    		return B[startB + k -1];
    	}
    	if (startB >= B.length) {
    		return A[startA + k -1];
    	}
    	if (k == 1) {
    		return Math.min(A[startA], B[startB]);
    	}

    	int keyA, keyB;
    	if (startA + k / 2 - 1 < A.length) {
    		keyA = A[startA + k / 2 - 1];
    	}
    	else {
    		return findKth(A, startA, B, startB + k / 2, k - k / 2);
    	}
    	if (startB + k / 2 - 1 < B.length) {
    		keyB = B[startB + k / 2 - 1];
    	}
    	else {
    		return findKth(A, startA + k / 2, B, startB, k - k / 2);
    	}

    	if (keyA < keyB) {
    		return findKth(A, startA + k / 2, B, startB, k - k / 2);
    	}
    	else {
    		return findKth(A, startA, B, startB + k / 2, k - k / 2);
    	}
    }

    public static void main(String[] args) {
    	MedianOfTwo solution = new MedianOfTwo();
        // int[] a = new int[] {1, 2, 3, 4, 5, 6};
        // int[] b = new int[] {2, 3, 4, 5};
        // int[] a = new int[] {};
        // int[] b = new int[] {1};
        // int[] a = new int[] {1};
        // int[] b = new int[] {1};
        int[] a = new int[] {1};
        int[] b = new int[] {2, 3, 4, 5, 6};
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
}