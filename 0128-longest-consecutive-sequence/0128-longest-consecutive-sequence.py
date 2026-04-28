class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest = 0
        for n in num_set:
            if n - 1 not in num_set:
                inc = 1
                while n + inc in num_set:
                    inc += 1
                longest = max(longest, inc)
        return longest

'''
brute force:
1. sort nums
o(nlogn + n) o(n)

-> iter nums
   create currG
   prevG = find(num - 1)
   nextG = find(num + 1)
   if prevG != -1 and nextG != -1:
    merge prevG, nextG, currG
   elif prevG != -1:
    merge(prevG, currG)
   elif nextG != -1:
    merge(nextG, currG)

key(num), value (groupId)
1, 2

1 (1, -1)

2 (2, 2) -> (2, 1)

4 (4, -1)

3 (3, -1)




100,4,200,1,3,2

100
'''