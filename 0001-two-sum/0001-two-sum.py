class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = dict()
        for i, num in enumerate(nums):
            val = target - num
            if val in hashmap:
                return [i, hashmap[val]]
            hashmap[num] = i

# [2,7,11,15] target = 9

# ai + aj = target

# ai aj i < j

# o(n**2) o(1)

# ai + aj = target
# aj = target - ai   i != j
# O(logn)
# O(nlogn)

# O(nlogn) o(1)

# O(1)

# o(n) o(n)