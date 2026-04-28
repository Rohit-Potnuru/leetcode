class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sumMap = dict()
        total = 0
        prefixSum = 0
        n = len(nums)
        sumMap[0] = 1
        for i in range(n):
            prefixSum += nums[i]
            if prefixSum - k in sumMap:
                total += sumMap[prefixSum - k]
            if prefixSum not in sumMap:
                sumMap[prefixSum] = 0
            sumMap[prefixSum] += 1
            
        return total