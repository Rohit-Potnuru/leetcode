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

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        curr = root
        kNode = None
        while curr:
            if curr.left:
                predecessor = self.getPredecessor(curr)
                if predecessor.right == curr:
                    predecessor.right = None
                    k -= 1
                    if k == 0:
                        return curr.val
                    curr = curr.right
                else:
                    predecessor.right = curr
                    curr = curr.left
            else: 
                k -= 1
                if k == 0:
                    return curr.val
                curr = curr.right
        return kNode