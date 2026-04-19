class Solution:
    def totalNQueens(self, n: int) -> int:
        horizontal = set()
        vertical = set()
        diagLeftRight = set()
        diagRightLeft = set()
        self.res = 0
        def backTrack(x: int, y: int, t: int):
            if t == 0:
                self.res += 1
                return
            i, j = x, y
            while i < n:
                while j < n:
                    if ((i not in horizontal) and
                       (j not in vertical) and
                       (i - j not in diagLeftRight) and
                       (i + j - n not in diagRightLeft)):
                        horizontal.add(i)
                        vertical.add(j)
                        diagLeftRight.add(i - j)
                        diagRightLeft.add(i + j - n)
                        backTrack(i + 1, 0, t - 1)
                        horizontal.remove(i)
                        vertical.remove(j)
                        diagLeftRight.remove(i - j)
                        diagRightLeft.remove(i + j - n)
                    j += 1
                j = 0
                i += 1
        backTrack(0, 0, n)
        return self.res


