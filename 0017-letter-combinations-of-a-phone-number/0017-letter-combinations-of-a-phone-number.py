class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        keyPad = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        def backTrack(pos: int, s: str):
            if pos == len(digits):
                res.append(s)
                return
            for ch in keyPad[digits[pos]]:
                backTrack(pos + 1, s + str(ch))
        res = []
        backTrack(0, "")
        return res
