"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def dfs(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return node
        newNode = Node(node.val)
        self.visited[node.val] = newNode
        for neighbor in node.neighbors:
            if not(neighbor.val in self.visited):
                self.dfs(neighbor)
            newNode.neighbors.append(self.visited[neighbor.val])
        return newNode

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        self.visited = dict()
        return self.dfs(node)