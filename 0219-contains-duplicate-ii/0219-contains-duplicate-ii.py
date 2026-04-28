class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        num_set = set()
        prev = 0
        for i, num in enumerate(nums):
            while i - prev > k:
                num_set.remove(nums[prev])
                prev += 1
            if num in num_set:
                return True
            num_set.add(num)
        return False