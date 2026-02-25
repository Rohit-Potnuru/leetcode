# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getRightMostNode(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        curr = node.left
        while curr.right and curr.right != node:
            curr = curr.right
        return curr

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        curr = root
        prev = float('inf')
        minDiff = float('inf')
        while curr:
            if curr.left:
                rightNode = self.getRightMostNode(curr)

                if rightNode.right:
                    rightNode.right = None
                    minDiff = min(minDiff, abs(prev - curr.val))
                    prev = curr.val
                    curr = curr.right
                else:
                    rightNode.right = curr
                    curr = curr.left
            else:
                minDiff = min(minDiff, abs(prev - curr.val))
                prev = curr.val
                curr = curr.right
        print(minDiff)
        return minDiff