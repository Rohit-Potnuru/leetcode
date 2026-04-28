class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        num_map = dict() # key(num), value(idx)
        prev = 0
        for i, num in enumerate(nums):
            if num in num_map and i - num_map[num] <= k:
                return True
            num_map[num] = i
        return False