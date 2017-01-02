// Subsets II Total Accepted: 33914 Total Submissions: 123231 My Submissions Question Solution 
// Given a collection of integers that might contain duplicates, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
// Hide Tags Array Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubset {

    public List<List<Integer>> subsetsWithDup(int[] S) {
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null) {
        	return null;
        }

        Arrays.sort(S);
        ArrayList<Integer> path = new ArrayList<Integer>();
        DFS(result, path, S, 0);
        return result;

    }

    public void DFS(ArrayList<List<Integer>> result, ArrayList<Integer> path, int[] S, int pos) {
    	result.add(new ArrayList<Integer>(path));

        for (int i = pos; i < S.length; ++i) {
            if (i > pos && S[i] == S[i - 1]) {
                continue;
            }
            path.add(S[i]);
            DFS(result, path, S, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        UniqueSubset A = new UniqueSubset();
        int[] S = {1, 2, 2, 3};
        List<List<Integer>> result;
        result = A.subsetsWithDup(S);;
        System.out.println(result);
    }
}