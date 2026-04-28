from collections import defaultdict
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        voc = defaultdict(int)
        i = 0
        maxx = 0
        for j, ch in enumerate(s):
            voc[ch] += 1
            while voc[ch] > 1:
                voc[s[i]] -= 1
                i += 1
            maxx = max(maxx, j - i + 1)
        return maxx