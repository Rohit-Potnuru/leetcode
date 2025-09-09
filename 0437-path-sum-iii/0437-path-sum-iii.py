# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution(object):
    def detectSum(self, root):
        if root == None:
            return

        curr = 0
        self.deque.appendleft(root.val)
        for element in self.deque:
            curr += element
            if curr == self.target:
                self.count += 1
        
        self.detectSum(root.left)
        self.detectSum(root.right)
        self.deque.popleft()
            
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: int
        """
        self.target = targetSum
        self.deque = deque()
        self.count = 0
        self.detectSum(root)
        return self.count
        