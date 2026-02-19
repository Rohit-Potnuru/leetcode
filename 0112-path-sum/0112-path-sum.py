# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        targetSum = targetSum - root.val
        res = False
        if root.left is None and root.right is None:
            print(root.val)
            return targetSum == 0
        if root.left is not None:
            res = res or self.pathSum(root.left, targetSum)
        if root.right is not None:
            res = res or self.pathSum(root.right, targetSum)
        return res

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        return self.pathSum(root, targetSum)