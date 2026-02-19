# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getSumNumbers(self, root: Optional[TreeNode], val: int):
        if root is None:
            return
        val = val * 10 + root.val
        if root.left is None and root.right is None:
            self.res = self.res + val
        self.getSumNumbers(root.left, val)
        self.getSumNumbers(root.right, val)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.res = 0
        self.getSumNumbers(root, 0)
        return self.res

        