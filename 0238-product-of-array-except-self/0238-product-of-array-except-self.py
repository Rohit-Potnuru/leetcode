class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)
        prevProd = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] = prevProd 
            prevProd = prevProd * nums[i]
        
        prevProd = 1
        for i, num in enumerate(nums):
            res[i] = prevProd * res[i]
            prevProd = prevProd * num
        return res
'''
nums = [1, 2, 3, 4]

brute force approach
  o(n x n) o(1)

precalucate suffix product
[ 1, 2,3,4]
[12,12,4,1]

prefixSum = 1

'''