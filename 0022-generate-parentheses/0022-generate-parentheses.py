class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backTrack(left: int, right: int, s: str):
            if len(s) == 2 * n:
                res.append(s)
            if left < n:
                backTrack(left + 1, right, s + '(')
            if right < left:
                backTrack(left, right + 1, s + ')')
        res = []
        backTrack(0, 0, '')
        return res