// Search Insert Position Total Accepted: 50239 Total Submissions: 141627 My Submissions Question Solution 
// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 --- 2
// [1,3,5,6], 2 --- 1
// [1,3,5,6], 7 --- 4
// [1,3,5,6], 0 --- 0

// Hide Tags Array Binary Search

public class SearchInsertionPosition {
	public int searchInsert(int[] A, int target) {
      
		if (A == null) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;
				
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				end = mid;
			}
			else if (A[mid] > target) {
				end = mid;
			}
			else if (A[mid] < target) {
				start = mid;
			}
		}

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		if (A[start] > target) {
			return start;
		}
		if (A[start] < target && A[end] > target) {
			return start + 1;
		}
		if (A[end] < target) {
			return end + 1;
		}

		return -1;
  	}

	public static void main(String[] args) {
		SearchInsertionPosition A = new SearchInsertionPosition();
		int[] B = {1, 3, 5, 6};
		System.out.println(A.searchInsert(B, 5));
	}

}