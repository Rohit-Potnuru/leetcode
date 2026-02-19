"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root
        queue = deque([root])
        while len(queue) > 0:
            size = len(queue)
            prev = None
            while size > 0:
                node = queue.popleft()
                if prev != None:
                    prev.next = node
                prev = node
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                size = size - 1
        return root