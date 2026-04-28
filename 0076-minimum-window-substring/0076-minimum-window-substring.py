from collections import defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tFreq = defaultdict(int)
        tCount = 0
        for ch in t:
            tFreq[ch] += 1
            if tFreq[ch] == 1:
                tCount += 1

        sFreq = defaultdict(int)
        sCount = 0
        i = 0
        minn = float('inf')
        minString = ""
        for j, ch in enumerate(s):
            sFreq[ch] += 1
            if sFreq[ch] == tFreq[ch]:
                sCount += 1
            while i < len(s) and sCount == tCount:
                sFreq[s[i]] -= 1
                if sFreq[s[i]] < tFreq[s[i]]:
                    sCount -= 1
                if minn > j - i + 1:
                    minString = s[i: j + 1]
                    minn = j - i + 1
                i += 1
        return minString
