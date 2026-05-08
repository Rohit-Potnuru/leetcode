"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        visitedMap = dict()
        queue = deque()
        if node == None:
            return None
        queue.append(node)
        visitedMap[node.val] = Node(node.val)
        while len(queue) > 0:
            size = len(queue)
            while size > 0:
                currNode = queue.popleft()
                for nextNode in currNode.neighbors:
                    if nextNode.val not in visitedMap:
                        queue.append(nextNode)
                        visitedMap[nextNode.val] = Node(nextNode.val)
                    visitedMap[currNode.val].neighbors.append(visitedMap[nextNode.val])
                size -= 1
        return visitedMap[node.val]