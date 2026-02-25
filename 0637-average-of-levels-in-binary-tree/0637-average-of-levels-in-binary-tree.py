# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        q = deque()
        q.append(root)
        res = []
        while len(q) > 0:
            size = len(q)
            summ, count = 0, size
            while size > 0:
                node = q.popleft()
                summ += node.val
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
                size -= 1
            res.append(summ/count)
        return res