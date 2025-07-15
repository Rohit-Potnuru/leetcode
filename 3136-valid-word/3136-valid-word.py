class Solution(object):
    def isValid(self, word):
        """
        :type word: str
        :rtype: bool
        """
        isvowel = False
        isConsonant = False

        for ch in word:
            if ch.lower() in ['a', 'e', 'i', 'o', 'u']:
               isvowel = True
            elif not ch.isdigit():
               isConsonant = True
        return len(word) >= 3 and word.isalnum() and isvowel and isConsonant
        