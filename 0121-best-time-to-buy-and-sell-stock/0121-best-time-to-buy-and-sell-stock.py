class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        low = prices[0]
        maxx = 0
        for price in prices:
            maxx = max(maxx, price - low)
            low = min(low, price)
        return maxx
'''

'''    