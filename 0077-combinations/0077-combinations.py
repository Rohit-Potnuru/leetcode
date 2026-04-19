class Solution:
    def backtrack(self, start, comb):
        if len(comb) == self.k:
            self.res.append(comb[:])
            return
        for i in range(start, self.n + 1):
            comb.append(i)
            self.backtrack(i + 1, comb)
            comb.pop()
    def combine(self, n: int, k: int) -> List[List[int]]:
        self.res = []
        self.k = k
        self.n = n
        self.backtrack(1, [])
        return self.res
