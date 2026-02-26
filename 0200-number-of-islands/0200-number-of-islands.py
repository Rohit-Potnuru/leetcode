class Solution:
    def getNeighbors(self, grid: List[List[str]], i: int, j: int, m: int, n: int) -> List[List[str]]:
        neighbor = [[1, 0], [0, -1], [-1, 0], [0, 1]]
        res = []
        for di, dj in neighbor:
            new_i = i + di
            new_j = j + dj
            if 0 <= new_i < m and 0 <= new_j < n and grid[new_i][new_j] == "1":
                res.append([new_i, new_j])
        return res

    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        q = deque()
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    grid[i][j] = "2"
                    q.append([i, j])
                    while len(q) > 0:
                        curr = q.pop()
                        neighbors = self.getNeighbors(grid, curr[0], curr[1], m, n)
                        for neig in neighbors:
                            grid[neig[0]][neig[1]] = "2"
                            q.append(neig)
        return count