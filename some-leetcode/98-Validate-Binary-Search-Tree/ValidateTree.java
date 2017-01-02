
// stack version
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        long prevVal = (long)Integer.MIN_VALUE - 1;
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if ((long)cur.val <= prevVal) return false;
            prevVal = cur.val;
            pushLeft(cur.right, stack);
        }
        return true;
    }
    
    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

// recursion version
// public class Solution {
//     private long curVal = (long)Integer.MIN_VALUE - 1;
    
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
        
//         if (!isValidBST(root.left)) {
//             return false;
//         }
//         if ((long)root.val <= curVal) {
//             return false;
//         }
//         curVal = root.val;
//         if (!isValidBST(root.right)) {
//             return false;
//         }
        
//         return true;
//     }
// }



// -------------------------------------- old -------------------------------

// public class ValidateTree {
//   //   public boolean isValidBST(TreeNode root) {
//   //   	if (root == null) {
//   //   		return true;
//   //   	}
 
//   //   	// 0 means left child, 1 means right child, 2 means root
//   //   	return helper(root, 0, 2);
//   //   	// return helper(root.left, root.val, 0) && helper(root.right, root.val, 1);
//   //   }

//   //   public boolean helper(TreeNode root, int parentVal, int whichSide) {
// 		// if (root == null) {
//   //   		return true;
//   //   	}

//   //   	boolean left = true;
//   //   	boolean right = true;
//   //   	if (root.left != null) {
//   //   		if (root.left.val >= root.val) {
//   //   			left = false;
//   //   		}
//   //   		if (whichSide == 1 && root.left.val <= parentVal) {
//   //   			right = false;
//   //   		}
//   //   	}
//   //   	if (root.right != null) {
//   //   		if (root.right.val <= root.val) {
//   //   			right = false;
//   //   		}
//   //   		if (whichSide == 0 && root.right.val >= parentVal) {
//   //   			left = false;
//   //   		}
//   //   	}
        
//   //       if (left && right) {
//   //       	return helper(root.left, Math.root.val, 0) && helper(root.right, root.val, 1);
//   //       }
//   //       else {
//   //       	return false;
//   //       }
//   //   }

//     // public boolean isValidBST(TreeNode root) {
//     //     // // just for the tricky test case
//     //     // if (root == null) {
//     //     //     return true;
//     //     // }
//     //     // if (root.left == null && root.right == null) {
//     //     //     return true;
//     //     // }

//     //     return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//     // }

//     // public boolean helper(TreeNode root, int minVal, int maxVal) {
//     //     if (root == null) {
//     //         return true;
//     //     }

//     //     if (root.val <= minVal || root.val >= maxVal) {
//     //         return false;
//     //     }

//     //     return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
//     // }


//     // AC, but complex
//     // int currMax = Integer.MIN_VALUE;
//     // int flag = 1;

//     // public boolean isValidBST(TreeNode root) {
//     //     if (root == null) {
//     //         return true;
//     //     }
//     //     if (root.left == null && root.right == null) {
//     //         return true;
//     //     }

//     //     return helper(root);
//     // }

//     // public boolean helper(TreeNode root) {
//     //     if (root == null) {
//     //         return true;
//     //     }

//     //     if (helper(root.left) == false) {
//     //         return false;
//     //     }
//     //     if (root.val <= currMax) {
//     //         if (currMax == Integer.MIN_VALUE && flag == 1) {
//     //             flag = 0;
//     //         }
//     //         else {
//     //             return false;
//     //         }
//     //     }
//     //     currMax = root.val;

//     //     return helper(root.right);
//     // }

//     // wrong solution, have not considered the whole subtree
//     /*
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
        
//         int left = 0, right = 1;
//         return validate(root.left, root.val, left) && validate(root.right, root.val, right);
//     }
    
//     private boolean validate(TreeNode root, int parentVal, int lefOrRig) {
//         if (root == null) {
//             return true;
//         }
//         if (lefOrRig == 0 && root.val >= parentVal) {
//             return false;
//         }
//         else if (lefOrRig == 1 && root.val <= parentVal) {
//             return false;
//         }
        
//         return validate(root.left, root.val, 0) && validate(root.right, root.val, 1);
//     }
//     */
    
//     // normal inorder traversal
//     /*
//     private ArrayList<Integer> res = new ArrayList<Integer>();
    
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
        
//         traversal(root);
//         int len = res.size();
//         for (int i = 1; i < len; ++i) {
//             if (res.get(i) <= res.get(i - 1)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     private void traversal(TreeNode root) {
//         if (root == null) {
//             return;
//         }
        
//         traversal(root.left);
//         res.add(root.val);
//         traversal(root.right);
//     }
//     */

//     // inplace inorder traversal
//     private TreeNode cur = null;
    
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
        
//         if (!isValidBST(root.left)) {
//             return false;
//         }
        
//         if (cur != null && root.val <= cur.val) {
//             return false;
//         }
//         cur = root;
        
//         if (!isValidBST(root.right)) {
//             return false;
//         }
        
//         return true;
//     }

// }