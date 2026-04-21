class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 1:
            return ["()"]
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
            return list(res)