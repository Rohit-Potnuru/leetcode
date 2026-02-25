# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        stack = [[root], []]
        curr = 0
        res = []
        while len(stack[0]) > 0 or len(stack[1]) > 0:
            size = len(stack[curr])
            temp = []
            while size > 0:
                node = stack[curr].pop()
                temp.append(node.val)
                if node.left and curr%2 == 0:
                    stack[(curr + 1) % 2].append(node.left)
                if node.right:
                    stack[(curr + 1) % 2].append(node.right)
                if node.left and curr%2 == 1:
                    stack[(curr + 1) % 2].append(node.left)
                size -= 1
            curr = (curr + 1)%2
            res.append(temp)
        return res