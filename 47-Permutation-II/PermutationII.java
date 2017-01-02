// Permutations II Total Accepted: 32026 Total Submissions: 124458 My Submissions Question Solution 
// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

// Hide Tags Backtracking

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;

// public class PermutationII {

//     public int times = 0;
//     private int[] visited;

//     public List<List<Integer>> permuteUnique(int[] num) {

//         visited = new int[num.length];

//         ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (num == null) {
//         	return null;
//         }

//         Arrays.sort(num);
//         ArrayList<Integer> path = new ArrayList<Integer>();
//         permuteHelper(result, path, num);
//         return result;
//     }

//     public void permuteHelper(ArrayList<List<Integer>> result, ArrayList<Integer> path, int[] num) {
//     	if (path.size() == num.length) {
//             ArrayList<Integer> newPath = new ArrayList<Integer>(path);
//             if (!(result.contains(newPath))) {
//         		result.add(newPath);            
//             }
//     	}

//     	for (int i = 0; i < num.length; ++i) {
//     		if (visited[i] == 1) {
//     			continue;
//     		}
//             // System.out.println(i);
//             ++times;
//     		path.add(num[i]);
//             visited[i] = 1;
//     		permuteHelper(result, path, num);
//     		path.remove(path.size() - 1);
//             visited[i] = 0;
//     	}
//     }

//     public static void main(String[] args) {
//     	PermutationII A = new PermutationII();
//     	int[] num = {3, 3, 0, 0, 2, 3, 2};
//     	System.out.println(A.permuteUnique(num));
//         System.out.println(A.times);
//     }
// }


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationII {

    // public int times = 0;
    private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] num) {

        if (num == null) {
            return null;
        }

        Arrays.sort(num);
        ArrayList<Integer> numInput = new ArrayList<Integer>(num.length);
        for (int i = 0; i < num.length; ++i) {
            numInput.add(num[i]);
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        permuteHelper(path, numInput);
        return result;
    }

    public void permuteHelper(ArrayList<Integer> path, ArrayList<Integer> num) {
        if (num.size() == 0) {
            result.add(new ArrayList<Integer>(path));            
        }

        for (int i = 0; i < num.size(); ++i) {
            if (i > 0 && num.get(i) == num.get(i - 1)) {
                continue;
            }

            // System.out.println(i);
            // ++times;
            path.add(num.get(i));
            ArrayList<Integer> sub = new ArrayList<Integer>(num);
            sub.remove(i);
            permuteHelper(path, sub);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationII A = new PermutationII();
        int[] num = {3, 3, 0, 0, 2, 3, 2};
        // int[] num = {1, 1, 2};
        System.out.println(A.permuteUnique(num));
        // System.out.println(A.times);
    }
}
