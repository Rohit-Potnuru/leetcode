# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxSum = float('-inf')
        def dfs(root):
            if root is None:
                return 0
            l = dfs(root.left)
            r = dfs(root.right)
            nodeSum = max(max(l, r) + root.val, root.val)
            self.maxSum = max(self.maxSum, l + r + root.val)
            self.maxSum = max(self.maxSum, nodeSum)
            return nodeSum
        dfs(root)
        return self.maxSum