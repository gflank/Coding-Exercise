// Permutations Total Accepted: 45428 Total Submissions: 142781 My Submissions Question Solution 
// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

// Hide Tags Backtracking

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null) {
        	return null;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        permuteHelper(result, path, num);
        return result;
    }

    public void permuteHelper(ArrayList<List<Integer>> result, ArrayList<Integer> path, int[] num) {
    	if (path.size() == num.length) {
    		result.add(new ArrayList<Integer>(path));
    	}

    	for (int i = 0; i < num.length; ++i) {
    		if (path.contains(num[i])) {
    			continue;
    		}

    		path.add(num[i]);
    		permuteHelper(result, path, num);
    		path.remove(path.size() - 1);
    	}
    }

    public static void main(String[] args) {
    	Permutation A = new Permutation();
    	int[] num = {1, 2, 3};
    	System.out.println(A.permute(num));
    }
}