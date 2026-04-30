class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right)//2
            
            if (mid - 1 < 0 or nums[mid - 1] < nums[mid]) and (mid + 1 >= len(nums) or nums[mid] > nums[mid + 1]):
                return mid
            elif (mid - 1 < 0 or nums[mid - 1] < nums[mid]) and (mid + 1 >= len(nums) or nums[mid] < nums[mid + 1]):
                left = mid + 1
            else:
                right = mid
        return left