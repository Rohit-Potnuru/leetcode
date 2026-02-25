# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getPredecessor(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        curr = node.left
        while curr.right and curr.right != node:
            curr = curr.right
        return curr

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = float('-inf')
        curr = root
        while curr:
            if curr.left:
                predecessor = self.getPredecessor(curr)
                if predecessor.right:
                    predecessor.right = None
                    if prev >= curr.val:
                        return False
                    prev = curr.val
                    curr = curr.right
                else:
                    predecessor.right = curr
                    curr = curr.left
            else:
                if prev >= curr.val:
                    return False
                prev = curr.val
                curr = curr.right
        return True