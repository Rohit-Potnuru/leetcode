# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preOrder(self, root, depth):
        if root is None:
            return
        if len(self.view) == depth:
            self.view.append(0)
        self.view[depth] = root.val
        self.preOrder(root.left, depth + 1)
        self.preOrder(root.right, depth + 1)

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.view = []
        self.preOrder(root, 0)
        return self.view