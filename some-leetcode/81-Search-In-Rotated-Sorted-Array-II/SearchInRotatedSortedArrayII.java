// Search in Rotated Sorted Array II Total Accepted: 32275 Total Submissions: 102317 My Submissions Question Solution 
// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.

// Hide Tags Array Binary Search

public class SearchInRotatedSortedArrayII {
    
    public boolean search(int[] A, int target) {
    	
    	if (A == null) {
    		return false;
    	}

    	int start = 0;
    	int end = A.length - 1;
    	int mid;

    	while (start + 1 < end) {
    		mid = start + (end - start) / 2;
    		if (A[mid] == target) {
    			return true;
    		}

    		if (A[mid] == A[start]) {
    			++start;
    		}
    		else if (A[mid] > A[start]) {
    			if (A[mid] > target && target >= A[start]) {
    				end = mid;
    			}
    			else {
    				start = mid;
    			}
    		}
    		else {
    			if (A[mid] < target && target <= A[end]) {
    				start = mid;
    			}
    			else {
    				end = mid;
    			}
    		}
    	}

  		if (A[start] == target) {
  			return true;
  		}
  		if (A[end] == target) {
  			return true;
  		}

  		return false;
    }

    public static void main(String[] args) {
    	SearchInRotatedSortedArrayII A = new SearchInRotatedSortedArrayII();
    	// int[] B = {4, 5, 6, 7, 0, 1, 2, 3};
    	// int[] B = {1, 1, 3, 1};
    	int[] B = {1, 3, 1, 1, 1};
    	System.out.println(A.search(B, 3));
    }
}