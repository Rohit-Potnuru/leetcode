# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if root is None:
                return [True, 0]
            l, l_dep = dfs(root.left)
            r, r_dep = dfs(root.right)
            return [l and r and abs(l_dep - r_dep) < 2, max(l_dep, r_dep) + 1]
        ans, dep = dfs(root)
        return ans