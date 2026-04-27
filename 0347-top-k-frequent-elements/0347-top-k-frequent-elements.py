import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = dict()
        for num in nums:
            if num not in freqMap:
                freqMap[num] = 0
            freqMap[num] += 1

        heap = []
        
        for key, count in freqMap.items():
            heapq.heappush(heap, (count, key))
            if len(heap) > k:
                heapq.heappop(heap)
        res = []
        while len(heap) != 0:
            (count, key) = heapq.heappop(heap)
            res.append(key)
        return res
        
'''
nums = [1,1,1,2,2,3], k = 2

sort list
nlogn + mlogm

hashMap
n + mlogm

hashMap + heap
1. freq
  iter through list
   -> if element not in hashmap
        -> insert element in hashmap
   -> increment + 1 
2. heap
  minHeap
  iter through hashmap
    -> insert (element, count)
    -> if len(heap) > k
       -> pop out element from top of the heap
n + mlogk


'''        