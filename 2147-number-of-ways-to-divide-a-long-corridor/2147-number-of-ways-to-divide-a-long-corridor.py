class Solution(object):
    # def numberOfWays(self, s):
    #     a = [i for i,c in enumerate(s) if c == 'S']
    #     res = 1
    #     for i in xrange(1,len(a) - 1,2):
    #         res *= a[i+1] - a[i]
    #         print(a[i + 1], a[i+1] - a[i])
    #     return res % (10**9+7) * (len(a) % 2 == 0 and len(a) >= 2) 

    def numberOfWays(self, corridor):
        """
        :type corridor: str
        :rtype: int
        """
        MODULO = 10**9 + 7
        totalCount = 1
        chairCount = 0
        totChairCount = 0
        i, n = 0, len(corridor)
        while i < n:
            if corridor[i] == 'S':
                chairCount += 1
                totChairCount += 1
            i += 1

            if chairCount == 2:
                chairCount = 0
                previ = i
                while i < n and corridor[i] == 'P':
                    i += 1
                if i == n:
                    break
                totalCount *= i - previ + 1
        if totChairCount != 0 and totChairCount % 2 == 0:
            return int(totalCount % MODULO)
        return 0