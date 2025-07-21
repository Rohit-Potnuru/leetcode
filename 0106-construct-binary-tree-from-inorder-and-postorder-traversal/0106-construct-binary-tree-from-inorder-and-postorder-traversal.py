# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_idx = dict()
        for idx, node in enumerate(inorder):
            inorder_idx[node] = idx
        
        root = TreeNode(postorder[-1])
        stack = deque()
        stack.append(root)

        for node in reversed(postorder[:-1]):
            currIdx, currNode = inorder_idx[node], TreeNode(node)
            topNode = stack[-1]
            if inorder_idx[topNode.val] < currIdx:
                topNode.right = currNode
            else:
                prevTopNode = stack[-1]
                while len(stack) != 0 and inorder_idx[stack[-1].val] > currIdx:
                    prevTopNode = stack.pop()
                prevTopNode.left = currNode
            stack.append(currNode)
        return root
