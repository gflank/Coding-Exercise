# Binary Tree Maximum Path Sum Total Accepted: 40101 Total Submissions: 187402 My Submissions Question Solution 
# Given a binary tree, find the maximum path sum.

# The path may start and end at any node in the tree.

# For example:
# Given the below binary tree,

#        1
#       / \
#      2   3
# Return 6.

# Hide Tags Tree Depth-first Search

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def maxPathSum(self, root):
    	self.max = INTMIN
        if not root: return INTMIN
        self.maxDownPath(root)
        return self.max

    def maxDownPath(self, root):
    	# if not root.left and not root.right:
    	# 	self.max = max(self.max, root.val)
    	# 	return root.val
    	left, right = INTMIN, INTMIN
    	if root.left
    		left = self.maxDownPath(root.left)
		if root.right
			right = self.maxDownPath(root.right)
		localMax = root.val
		if left > 0
			localMax +=left
		if right > 0
			localMax += right
		self.max = max(self.max, localMax)

		if left < 0 and right < 0
			return root.val
		else 
			return max(left, right) + root.val