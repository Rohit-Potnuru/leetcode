class Solution(object):
    def possibleStringCount(self, word):
        """
        :type word: str
        :rtype: int
        """
        count, prevCh = 1, '.'
        total = 1
        for ch in word:
            if prevCh != ch:
                prevCh = ch
                total += count - 1
                count = 0
            count += 1
        total += count - 1
        return total
        