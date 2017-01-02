// faster version
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, path, res, target, 0);
        return res;
    }
    
    private void dfs(int[] candidates, List<Integer> path, List<List<Integer>> res, int remain, int pos) {
        // loop through all the posibilities
        for (int i = pos; i < candidates.length; ++i) {
            int newRemain = remain - candidates[i];
            if (newRemain > 0) {
                path.add(candidates[i]);
                dfs(candidates, path, res, newRemain, i);
                path.remove(path.size() - 1);
            }
            else if (newRemain == 0) {
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(candidates[i]);
                res.add(newPath);
            }
            else {
                break;
            }
        }
    }
}

// // rewrote version
// public class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (candidates.length == 0) {
//             return res;
//         }
        
//         List<Integer> path = new ArrayList<>();
//         dfs(candidates, target, path, res, 0, 0);
//         return res;
//     }
    
//     private void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> res, int prevSum, int pos) {
//         if (prevSum == target) {
//             List<Integer> newPath = new ArrayList<Integer>(path);
//             Collections.sort(newPath);
//             res.add(newPath);
//             return;
//         }
//         else if (prevSum > target) {
//             return;
//         }
        
//         // loop through all the posibilities
//         for (int i = pos; i < candidates.length; ++i) {
//             path.add(candidates[i]);
//             prevSum += candidates[i];
//             dfs(candidates, target, path, res, prevSum, i);
//             path.remove(path.size() - 1);
//             prevSum -= candidates[i];
//         }
//     }
// }

// import java.util.*;

// public class CombinationSum {
//     private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         if (candidates == null) {
//         	return result;
//         }

//         Arrays.sort(candidates);
//         ArrayList<Integer> path = new ArrayList<Integer>();
//         comHelper(candidates, target, path, 0);

//         return result;
//     }

//     private void comHelper(int[] candidates, int target, ArrayList<Integer> path, int index) {
//     	int pathSum = 0;
//     	for (int i = 0; i < path.size(); ++i) {
//     		pathSum += path.get(i);
//     	}
//     	if (pathSum == target) {
//     		result.add(new ArrayList<Integer>(path));
//     	}
//     	else if (pathSum > target) {
//     		return;
//     	}

//     	int prev = Integer.MIN_VALUE;
//     	for (int i = index; i < candidates.length; ++i) {
//     		if (prev != Integer.MIN_VALUE && candidates[i] == prev) {
//     			continue;
//     		}
//     		path.add(candidates[i]);
//     		comHelper(candidates, target, path, i);
//     		path.remove(path.size() - 1);
//     		prev = candidates[i];
//     	}
//     }
// }