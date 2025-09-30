class Solution(object):
    def triangularSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) - 1
        factorial_n = 1
        for i in range(1, n + 1):
            factorial_n = factorial_n * i
        
        factorial_n_r = 1
        summ = nums[0]
        for i in range(1, n + 1):
            factorial_n_r = (factorial_n_r * (n - i + 1))/i
            summ = (summ + (factorial_n_r * nums[i]) % 10) % 10
        
        return summ