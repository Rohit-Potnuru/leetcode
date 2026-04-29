class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        min_k = 1
        max_k = 10**9


        def getSpeed(k):
            count = 0
            for pile in piles:
                count += pile//k + (pile % k > 0)
            return count

        while min_k < max_k:
            mid = (max_k - min_k)//2 + min_k
            speed = getSpeed(mid)
            if h < speed:
                min_k = mid + 1
            else:
                max_k = mid
        return max_k
