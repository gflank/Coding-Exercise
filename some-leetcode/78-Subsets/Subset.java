// Subsets Total Accepted: 43806 Total Submissions: 155357 My Submissions Question Solution 
// Given a set of distinct integers, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
// Hide Tags Array Backtracking Bit Manipulation

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] S) {
        
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
            path.add(S[i]);
            DFS(result, path, S, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset A = new Subset();
        int[] S = {1, 2, 3};
        List<List<Integer>> result;
        result = A.subsets(S);;
        System.out.println(result);
    }
}





// public ArrayList<ArrayList<Integer>> subsets(int[] S) {
//        if (S == null)
//            return null;
//
//        Arrays.sort(S);
//        for (int i : S) {
//            System.out.println(i);
//        }
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        for (int i = 0; i < S.length; i++) {
//            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//
//            //get sets that are already in result
//            for (ArrayList<Integer> a : result) {
//                temp.add(new ArrayList<Integer>(a));
//            }
//
//            //add S[i] to existing sets
//            for (ArrayList<Integer> a : temp) {
//                a.add(S[i]);
//            }
//
//            System.out.println("add S[i] to existing sets, temp is: " + temp);
//
//            //add S[i] only as a set
//            ArrayList<Integer> single = new ArrayList<Integer>();
//            single.add(S[i]);
//            System.out.println("single is: "+ single);
//            temp.add(single);
//            System.out.println("temp is: " + temp);
//
//            result.addAll(temp);
//            System.out.println("result is: " + result);
//        }
//
//        //add empty set
//        result.add(new ArrayList<Integer>());
//
//        return result;
//    }

//        public ArrayList<ArrayList<Integer>> subsets(int[] S) {
//            Arrays.sort(S);
//            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
//            subsets.add(new ArrayList<Integer>());
//            for (int i = 0; i < S.length; i++) {
//                int size = subsets.size();
//                for (int j = 0; j < size; j++) {
//                    ArrayList<Integer> subset = new ArrayList<Integer>(
//                            subsets.get(j));
//                    subset.add(S[i]);
//                    subsets.add(subset);
//                }
//            }
//            return subsets;
//        }