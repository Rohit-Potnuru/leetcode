# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(root):
            if root is None:
                return 0, None
            l_dep, l_lca = dfs(root.left)
            r_dep, r_lca = dfs(root.right)
            if l_dep == r_dep:
                return l_dep + 1, root
            
            if l_dep > r_dep:
                return l_dep + 1, l_lca
            else:
                return r_dep + 1, r_lca
        max_dep, lca = dfs(root)
        return lca