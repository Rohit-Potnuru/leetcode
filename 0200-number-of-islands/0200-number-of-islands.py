class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        def dfs(i, j):
            grid[i][j] = "2"
            neighbors = [[0, 1], [1, 0], [0, -1], [-1, 0]]
            for di, dj in neighbors:
                if 0 <= i + di <  m and 0 <= j + dj < n and grid[i + di][j + dj] == "1":
                    dfs(i + di, j + dj)
            return 
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    dfs(i, j)
        return count