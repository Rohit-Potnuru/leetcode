# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def merge(left: int, right: int):
            if right <= left:
                return None
            mid = (right - left)//2 + left
            root = TreeNode(nums[mid])
            root.left = merge(left, mid)
            root.right = merge(mid + 1, right)
            return root
        return merge(0, len(nums))

