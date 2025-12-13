class Solution(object):
    def validateCoupons(self, code, businessLine, isActive):
        """
        :type code: List[str]
        :type businessLine: List[str]
        :type isActive: List[bool]
        :rtype: List[str]
        """
        res = []
        pattern = r'^[a-zA-Z0-9_]+$'
        bussinessList = {"electronics": 0, "grocery": 1, "pharmacy": 2, "restaurant": 3}
        for c, bl, act in zip(code, businessLine, isActive):
            if (
                re.match(pattern, c) 
                and bl in bussinessList 
                and act
               ):
                res.append((c, bussinessList[bl], act))
        res = sorted(res, key = lambda r: (r[1], r[0]))
        return map(lambda r: r[0], res)