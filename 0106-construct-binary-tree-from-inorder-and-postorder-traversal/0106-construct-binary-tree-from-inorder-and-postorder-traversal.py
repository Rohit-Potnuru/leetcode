# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
         inorder_idx = {val: idx for idx, val in enumerate(inorder)}
        
        root = TreeNode(postorder[-1])
        stack = [root]

        for node in reversed(postorder[:-1]):
            curr_idx = inorder_idx[node]
            curr_node = TreeNode(node)
            
            if inorder_idx[stack[-1].val] < curr_idx:
                stack[-1].right = curr_node
            else:
                parent = None
                while stack and inorder_idx[stack[-1].val] > curr_idx:
                    parent = stack.pop()
                parent.left = curr_node
            stack.append(curr_node)
        return root
