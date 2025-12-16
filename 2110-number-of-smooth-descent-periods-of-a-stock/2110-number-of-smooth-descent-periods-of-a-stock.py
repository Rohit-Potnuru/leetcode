class Solution(object):
    def getDescentPeriods(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        count = 0
        prev = prices[0] - 2
        res = 0
        for i in range(len(prices)):
            if prev - 1 == prices[i]:
                count += 1
            else:
                res += (count * (count + 1))/2
                count = 1
            prev = prices[i]
        res += (count * (count + 1))/2
        return res