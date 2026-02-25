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
        count = 0
        kNode = None
        while curr:
            if curr.left:
                predecessor = self.getPredecessor(curr)
                if predecessor.right == curr:
                    predecessor.right = None
                    count += 1
                    if count == k:
                        kNode = curr.val
                    curr = curr.right
                else:
                    predecessor.right = curr
                    curr = curr.left
            else: 
                count += 1
                if count == k:
                    kNode = curr.val
                curr = curr.right
        return kNode