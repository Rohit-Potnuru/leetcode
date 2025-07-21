# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        elif root.val == key:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                curr = root.right
                prev_curr = None
                while curr.left:
                    prev_curr = curr
                    curr = curr.left
                
                if prev_curr:
                    prev_curr.left = None
                
                curr_r = curr
                while curr_r.right:
                    curr_r = curr_r.right
                if curr != root.right:
                    curr_r.right = root.right
                curr.left = root.left
                return curr

        else:
            root.left = self.deleteNode(root.left, key)
            root.right = self.deleteNode(root.right, key)
        return root