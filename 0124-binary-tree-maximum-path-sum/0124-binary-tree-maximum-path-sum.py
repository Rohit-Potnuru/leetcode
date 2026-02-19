# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMaxPathSum(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        left = self.getMaxPathSum(root.left)
        right = self.getMaxPathSum(root.right)
        maxChildSum = max(root.val, root.val + max(left, right))
        self.max = max(self.max, maxChildSum, root.val + left + right)

        return maxChildSum

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max = float('-inf')
        self.getMaxPathSum(root)
        return self.max