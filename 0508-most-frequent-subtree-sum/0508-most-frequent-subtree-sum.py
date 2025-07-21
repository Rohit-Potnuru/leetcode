# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def getTreeSum(self, root):
        if root is None:
            return 0

        tree_sum = root.val + self.getTreeSum(root.left) + self.getTreeSum(root.right)
        if tree_sum not in self.frequentTreeSum:
            self.frequentTreeSum[tree_sum] = 0
        self.frequentTreeSum[tree_sum] += 1
        return tree_sum

    def findFrequentTreeSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """

        self.frequentTreeSum = dict()
        self.getTreeSum(root)

        maxFreqList = []
        maxFreq = 0
        for tree_sum in self.frequentTreeSum:
            if maxFreq < self.frequentTreeSum[tree_sum]:
                maxFreqList = []
                maxFreq = self.frequentTreeSum[tree_sum]
                maxFreqList.append(tree_sum)

            elif maxFreq == self.frequentTreeSum[tree_sum]:
                maxFreqList.append(tree_sum)
        return maxFreqList
        