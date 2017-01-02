// Search for a Range Total Accepted: 38963 Total Submissions: 140959 My Submissions Question Solution 
// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// Hide Tags Array Binary Search

public class SearchRange {
  
    public int[] searchRange(int[] A, int target) {


        if (A == null){
            int[] range = {-1, -1};
	    	return range;
    	}  

    	//start part
        int rangeStart = -1, rangeEnd = -1;
    	int start = 0;
    	int end = A.length - 1;
    	int mid;
    	int judge = 0;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A[mid] == target){
    			end = mid;
    		}
    		else if (A[mid] > target){
    			end = mid;
    		}
    		else if (A[mid] < target){
    			start = mid;
    		}
    	}

    	if (A[start] ==  target){
    		rangeStart = start;
    		++judge;
    	}
    	else if (A[end] == target){
            rangeStart = end;
    		++judge;
    	}
			
		//end part
    	start = 0;
    	end = A.length - 1;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A[mid] == target){
    			start = mid;
    		}
    		else if (A[mid] > target){
    			end = mid;
    		}
    		else if (A[mid] < target){
    			start = mid;
    		}
    	}

    	if (A[end] == target){
            rangeEnd = end;
    		++judge;
    	}
    	else if (A[start] ==  target){
            rangeEnd = start;
    		++judge;
    	}

    	if (judge > 0){
            int[] range = {rangeStart, rangeEnd};
    		return range;
    	}

        int[] range = {-1, -1}; 
    	return range;

    }
}

