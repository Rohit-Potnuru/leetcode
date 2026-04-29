class Solution:
    def validPalindrome(self, s: str) -> bool:
        def validPalindrome(i: int, j: int, delCount: int):
            if i >= j:
                return True
            elif s[i] == s[j]:
                return validPalindrome(i + 1, j - 1, delCount)
            elif delCount > 0:
                return validPalindrome(i, j - 1, delCount - 1) or validPalindrome(i + 1, j, delCount - 1)
            else:
                return False
            
        return validPalindrome(0, len(s) - 1, 1)