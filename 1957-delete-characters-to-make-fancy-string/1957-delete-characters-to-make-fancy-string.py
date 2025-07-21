class Solution:
    def makeFancyString(self, s: str) -> str:
        count = 0
        currCh = '0'
        strBuilder = []
        for ch in s:
            if ch != currCh:
                currCh = ch
                count = 0
            count += 1
            if count <= 2:
                strBuilder.append(ch)
        return ''.join(strBuilder)