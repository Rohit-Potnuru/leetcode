# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def MaxDepth(self, node: Optional[TreeNode], maxDepth: int) -> int:
        if node is None:
            return 0
        if maxDepth == 0:
            return 1
        left = self.MaxDepth(node.left, maxDepth - 1)
        right = self.MaxDepth(node.right, maxDepth - 1)
        return left + right

    def countNodes(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        maxDepthRight = 1
        curr = root
        while curr.right is not None:
            curr = curr.right
            maxDepthRight += 1
        
        maxDepthLeft = 1
        curr = root
        while curr.left is not None:
            curr = curr.left
            maxDepthLeft += 1

        print(maxDepthLeft)
        val = 2**maxDepthRight - 1
        if maxDepthLeft == maxDepthRight:
            return val
        
        maxDepthCount = self.MaxDepth(root, maxDepthLeft - 1)
        return val + maxDepthCount
        
