# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        idxMap = dict()
        for idx, val in enumerate(inorder):
            idxMap[val] = idx

        root = TreeNode(-1)
        stack = [[root, len(inorder)]]

        for val in preorder:
            node = TreeNode(val)
            idx = idxMap[val]
            
            if idx < stack[-1][1]:
                stack[-1][0].left = node
            else:
                prevPop = None
                while idx > stack[-1][1]:
                    prevPop = stack.pop()
                prevPop[0].right = node
            
            stack.append([node, idx])
        return root.left

'''
root left right
left root right

[3,9,20,15,7]
[9,3,15,20,7]
       3

'''