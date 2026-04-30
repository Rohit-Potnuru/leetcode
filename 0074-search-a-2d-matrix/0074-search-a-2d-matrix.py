class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m
        while l < r:
            mid = (l + r) // 2
            if matrix[mid][n - 1] < target:
                l = mid + 1
            else:
                r = mid
        row = l
        if row >= m:
            return False
        l, r = 0, n
        while l < r:
            mid = (l + r)//2
            if matrix[row][mid] < target:
                l = mid + 1
            else:
                r = mid
        return matrix[row][l] == target
