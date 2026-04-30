class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def getTotalDays(capacity: int):
            totalDays = 1
            currCap = capacity
            for weight in weights:
                if weight > capacity:
                    return float('inf')
                if currCap < weight:
                    currCap = capacity
                    totalDays += 1
                currCap -= weight
            return totalDays
        
        min_cap = 1
        max_cap = 25 * 10**6
        while min_cap < max_cap:
            mid_cap = (max_cap - min_cap)//2 + min_cap
            curr_days = getTotalDays(mid_cap)
            print(mid_cap, curr_days)
            if curr_days <= days:
                max_cap = mid_cap
            else:
                min_cap = mid_cap + 1
        return min_cap
                