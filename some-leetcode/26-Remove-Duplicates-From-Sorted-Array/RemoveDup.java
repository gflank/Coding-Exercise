// Remove Duplicates from Sorted Array Total Accepted: 54770 Total Submissions: 173939 My Submissions Question Solution 
// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].

// Hide Tags Array Two Pointers

public class RemoveDup {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }

        int length = 1;
        for (int i = 1; i < A.length; ++i) {
        	if (A[i] != A[i - 1]) {
        		A[length] = A[i];
        		++length;
        	}
        }

        return length;
    }

    public static void main(String[] args) {
    	RemoveDup A = new RemoveDup();
    	// int[] num = new int[] {1, 2, 2};
    	int[] num = new int[] {1, 1, 2};
    	// System.out.println(A.removeDuplicates(num));
    	for (int i : num) {
    		System.out.println(i);
    	}
    }
}