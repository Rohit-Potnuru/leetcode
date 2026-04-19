class Solution:
    def permutation(self, nums: List[int], start: int):
        n = len(nums)
        if start == n - 1:
            self.res.append(nums[:])
            return
        for i in range(start, n):
            nums[i], nums[start] = nums[start], nums[i]
            self.permutation(nums, start + 1)
            nums[i], nums[start] = nums[start], nums[i]
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.permutation(nums, 0)
        return self.res
       


