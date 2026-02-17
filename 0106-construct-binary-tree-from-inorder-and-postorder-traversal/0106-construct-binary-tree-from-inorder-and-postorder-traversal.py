# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idxMap = dict()
        for idx, val in enumerate(inorder):
            idxMap[val] = idx
        
        root = TreeNode(-1)
        stack = [(root, -1)]
        for val in reversed(postorder):
            node = TreeNode(val)
            idx = idxMap[val]

            if stack[-1][1] < idx:
                stack[-1][0].right = node
            else:
                prev = None
                while stack[-1][1] > idx:
                    prev = stack.pop()[0]
                prev.left = node
            stack.append((node, idx))
        return root.right
        '''
        
              1
            2   3
           4 5 6 7

        4 2 5 1 6 3 7
        4 5 2 6 7 3 1
        1 3 7 6 2 5 4

        1 6

        L ro R
        L R ro

        1 2 4 5 3 6 7
        '''
        idxMap = dict()
        for idx, val in enumerate(postorder):
            idxMap[val] = idx

        root = TreeNode(-1)
        stack = [(root, len(inorder))]

        for val in inorder:
            node = TreeNode(val)
            idx = idxMap[val]

            stack.append(node)
