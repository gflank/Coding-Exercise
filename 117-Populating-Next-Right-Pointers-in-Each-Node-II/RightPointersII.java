// Populating Next Right Pointers in Each Node II Total Accepted: 36998 Total Submissions: 115887 My Submissions Question Solution 
// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL
// Hide Tags Tree Depth-first Search

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
          return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        TreeLinkNode current;
        TreeLinkNode last = null;

        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                current = queue.poll();
                if (last != null) {
                    last.next = current;
                }

                // push the child into the queue
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                last = current;
            }
            last = null;
        }
    }
}