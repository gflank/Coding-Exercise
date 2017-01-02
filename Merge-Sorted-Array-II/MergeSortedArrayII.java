// LintCode
// Easy Merge Sorted Array II

// 42% Accepted
// Given two sorted integer arrays A and B, merge B into A as one sorted array.

// Note
// You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are mand n respectively.

// Example
// A = [1, 2, 3, empty, empty] B = [4,5]

// After merge, A will be filled as [1,2,3,4,5]

// Tags Expand 
// Sorted Array Array

class MergeSortedArrayII {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	int execute = 0;
        if (m == 0 && n == 0) {
        	execute = 1;
        }
        else if (m == 0) {
        	for (int i = 0; i < n; ++i) {
        		A[i] = B[i];
        	}
        	execute = 1;
        }
        else if (n == 0) {
        	execute = 1;
        }

        if (execute == 0) {
	    	int APoint = m - 1;
        	int BPoint = n - 1;
        	int point = m + n - 1;
        	while (true) {
        		if (A[APoint] >= B[BPoint]) {
        			A[point] = A[APoint];
        			--APoint;
        		}
        		else {
        			A[point] = B[BPoint];
        			--BPoint;
        		}
        		--point;

        		if (point == -1) {
        			break;
        		}
        		if (APoint == -1) {
        			System.out.println("here");
        			for (int i = BPoint; i >= 0; --i) {
        				A[point] = B[BPoint];
        				--point;
        				--BPoint;
        			}
        			break;
        		}
        		if (BPoint == -1) {
        			break;
        		}
        	}
        }
    }

    public static void main(String[] args) {
    	MergeSortedArrayII Solution = new MergeSortedArrayII();
    	// int[] A = {1, 3, 5, 7, 0, 0, 0, 0};
    	int[] A = {9, 10, 11, 12, 13, 0, 0, 0, 0};
    	int[] B = {4, 5, 6, 7};
    	Solution.mergeSortedArray(A, 5, B, B.length);
    	for (int i : A) {
    		System.out.println(i);
    	}
    }
}
