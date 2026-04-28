class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        parent = dict()
        size = dict()
        def find(curr):
            if curr not in parent:
                return None
            if parent[curr] != curr:
                parent[curr] = find(parent[curr])
            return parent[curr]
        
        def union(a, b):
            ra, rb = find(a), find(b)
            if ra == rb:
                return size[ra]
            if size[ra] < size[rb]:
                ra, rb = rb, ra
            parent[rb] = ra
            size[ra] += size[rb]
            return size[ra]
            
        maxx = 0
        for num in nums:
            left = find(num - 1)
            right = find(num + 1)
            if num in parent:
                continue
            parent[num] = num
            size[num] = 1
            count = 1
            if left is not None and right is not None:
                union(num, left)
                count = union(right, num)
            elif right is not None:
                count = union(right, num)
            elif left is not None:
                count = union(left, num)
            maxx = max(count, maxx)
        return maxx

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