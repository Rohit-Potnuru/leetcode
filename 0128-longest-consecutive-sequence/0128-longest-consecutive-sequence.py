class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        groupMap = dict()
        def find(val):
            if val not in groupMap:
                return None
            curr = val
            while curr in groupMap and groupMap[curr][0]:
                curr = groupMap[curr][1]
            parent = curr

            # curr = val
            # while groupMap[curr] >= 0:
            #     curr, groupMap[curr] = groupMap[curr], parent
            return parent
        
        def union(g1, g2):
            count1 = groupMap[g1][1]
            count2 = groupMap[g2][1]
            if count1 < count2:
                groupMap[g1] = (True, g2)
                groupMap[g2] = (False, count1 + count2)
            else: 
                groupMap[g2] = (True, g1)
                groupMap[g1] = (False, count1 + count2)
            return count1 + count2
        maxx = 0
        for num in nums:
            leftGroup = find(num - 1)
            rightGroup = find(num + 1)
            if num in groupMap:
                continue
            groupMap[num] = (False, 1)
            count = 1
            if leftGroup != None and rightGroup != None:
                union(leftGroup, num)
                count = union(rightGroup, leftGroup)
            elif rightGroup != None:
                count = union(rightGroup, num)
            elif leftGroup != None:
                count = union(leftGroup, num)
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