class Solution:
    def isValid(self, x1, y1, y2, horizontalSum, verticalSum, grid):
        currHSum = horizontalSum[x1][y2] - horizontalSum[x1][y1] + grid[x1][y1]
        
        dy = y2 - y1 + 1
        m, n = len(horizontalSum), len(horizontalSum[0])
        if x1 + dy > m:
            return False
        for x2 in range(x1 + 1, x1 + dy):
            tempSum = horizontalSum[x2][y2] - horizontalSum[x2][y1] + grid[x2][y1]
            if tempSum != currHSum:
                return False
        x2 = x1 + dy - 1
        for tempy in range(y1, y2 + 1):
            tempSum = verticalSum[x2][tempy] - verticalSum[x1][tempy] + grid[x1][tempy]
            if tempSum != currHSum:
                return False
        tempLSum = 0
        tempRSum = 0
        for temp in range(dy):
            tempLSum += grid[x1 + temp][y1 + temp]
            tempRSum += grid[x1 + temp][y2 - temp]
        if tempLSum != currHSum or tempRSum != currHSum:
            return False
        return True

    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        horizontalSum = [[0] * n for i in range(m)]
        verticalSum = [[0] * n for i in range(m)]

        for x in range(m):
            prevHSum = 0
            for y in range(n):
                prevHSum += grid[x][y]
                horizontalSum[x][y] += prevHSum

        for y in range(n):
            prevVSum = 0
            for x in range(m):
                prevVSum += grid[x][y]
                verticalSum[x][y] += prevVSum

        maxx = 1
        for x1 in range(m):
            for y1 in range(n):
                for y2 in range(y1 + 1, n):
                    if(self.isValid(x1, y1, y2, horizontalSum, verticalSum, grid)):
                        maxx = max(maxx, y2 - y1 + 1)
        return maxx
        # 0 1 2 3

        # 5 1 3 1
        # 9 3 3 1
        # 1 3 3 8

        # 5 6 9 10