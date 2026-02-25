# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        leftBool = (left == p or left == q)
        rightBool = (right == p or right == q)
        rootBool = (root == p or root == q)
        if rootBool or (leftBool and rightBool):
            return root
        elif left != None:
            return left
        elif right != None:
            return right
        else: 
            return None


