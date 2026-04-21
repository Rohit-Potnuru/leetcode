class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if not hasattr(self, 'memo'):
            self.memo = {}
        if n == 1:
            return ["()"]
        elif n in self.memo:
            return self.memo[n]
        else:
            res = set()
            for i in range(1, n):
                leftList = self.generateParenthesis(i)
                rightList = self.generateParenthesis(n - i)
                for rightPranthesis in rightList:
                    for leftPranthesis in leftList:
                        res.add(leftPranthesis + rightPranthesis)
                    if i == 1:
                        res.add('(' + rightPranthesis + ')')
            self.memo[n] = list(res)
            return self.memo[n]