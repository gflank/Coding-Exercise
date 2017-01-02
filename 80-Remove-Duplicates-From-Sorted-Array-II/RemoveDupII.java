// Remove Duplicates from Sorted Array II Total Accepted: 36833 Total Submissions: 120145 My Submissions Question Solution 
// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].

// Hide Tags Array Two Pointers

public class RemoveDupII {
    public int removeDuplicates(int[] A) {
			if (A == null || A.length == 0) {
				return 0;
			}

			int length = 1;
			int record = 0;
			for (int i = 1; i < A.length; ++i) {
				if (A[i] != A[i - 1]) {
					A[length] = A[i];
					++length;
					record = 0;
				}
				else {
					if (record == 0) {
						A[length] = A[i];
						++length;
						++record;
					}
				}
			}
			
			return length;
    }

    public static void main(String[] args) {
    	RemoveDupII A = new RemoveDupII();
    	int[] num = {1, 1, 1, 2, 2, 3};
    	System.out.println(A.removeDuplicates(num));
    	for (int i : num) {
    		System.out.println(i);
    	}
    }
}