class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        prevRes = [[i + 1] for i in range(n)]
        res = prevRes
        for pos in range(2, k + 1):
            res = []
            for r in prevRes:
                for i in range(r[-1] + 1, n + 1):
                    res.append(r + [i])
            prevRes = res
        return res
