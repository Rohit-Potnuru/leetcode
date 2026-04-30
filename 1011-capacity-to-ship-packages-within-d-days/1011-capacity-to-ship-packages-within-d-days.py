class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def getDays(capacity: int) -> int:
            totalDays = 1
            currCap = capacity
            for weight in weights:
                if currCap < weight:
                    currCap = capacity
                    totalDays += 1
                currCap -= weight
            return totalDays
        
        left = max(weights)       # must fit heaviest package
        right = sum(weights)      # ship all in one day
        while left < right:
            mid = (left + right) // 2
            if getDays(mid) <= days:
                right = mid
            else:
                left = mid + 1
        return left