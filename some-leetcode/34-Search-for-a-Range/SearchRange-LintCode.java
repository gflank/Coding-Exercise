// Medium Search for a Range

// 21% Accepted
// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// Tags Expand 
// Binary Search Sorted Array Array

import java.util.ArrayList;

public class SearchRange-LintCode {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
    	ArrayList<Integer> range = new ArrayList<Integer>();

    	if (A.size() == 0){
	    	range.add(-1);
	    	range.add(-1);
	    	return range;
    	}  

    	//start part
    	int start = 0;
    	int end = A.size() - 1;
    	int mid;
    	int judge = 0;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A.get(mid) == target){
    			end = mid;
    		}
    		else if (A.get(mid) > target){
    			end = mid;
    		}
    		else if (A.get(mid) < target){
    			start = mid;
    		}
    	}

    	if (A.get(start) ==  target){
    		range.add(start);
    		++judge;
    	}
    	else if (A.get(end) == target){
    		range.add(end);
    		++judge;
    	}
			
		//end part
    	start = 0;
    	end = A.size() - 1;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A.get(mid) == target){
    			start = mid;
    		}
    		else if (A.get(mid) > target){
    			end = mid;
    		}
    		else if (A.get(mid) < target){
    			start = mid;
    		}
    	}

    	if (A.get(end) == target){
    		range.add(end);
    		++judge;
    	}
    	else if (A.get(start) ==  target){
    		range.add(start);
    		++judge;
    	}

    	if (judge > 0){
    		return range;
    	}

    	range.add(-1);
    	range.add(-1);
    	return range;

    }
}

