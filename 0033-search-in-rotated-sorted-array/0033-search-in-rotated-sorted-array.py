class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)
        while left < right:
            mid = (left - right)//2 + right
            print(left, right, mid)
            if target == nums[mid]:
                return mid
            elif nums[left] < nums[mid]:
                if nums[left] <= target:
                    right = mid
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[left]:
                    left = mid + 1
                else:
                    right = mid
        return -1