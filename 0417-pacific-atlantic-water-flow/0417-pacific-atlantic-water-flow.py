class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        pacificVisited = [[False] * n for i in range(m)]
        atlanticVisited = [[False] * n for i in range(m)]

        def bfs(queue, visited):
            while len(queue) > 0:
                [i, j] = queue.popleft()
                for di, dj in ((0, 1), (1, 0), (0, -1), (-1, 0)):
                    if 0 <= i + di < m and 0 <= j + dj < n and not visited[i + di][j + dj] and heights[i + di][j + dj] >= heights[i][j]:
                        queue.append([i + di, j + dj])
                        visited[i + di][j + dj] = True

        for i in range(m):
            if not pacificVisited[i][0]:
                pacificVisited[i][0] = True
                bfs(deque([[i, 0]]), pacificVisited)
            
            if not atlanticVisited[i][n - 1]:
                atlanticVisited[i][n - 1] = True
                bfs(deque([[i, n - 1]]), atlanticVisited)

        for j in range(n):
            if not pacificVisited[0][j]:
                pacificVisited[0][j] = True
                bfs(deque([[0, j]]), pacificVisited)
            
            if not atlanticVisited[m - 1][j]:
                atlanticVisited[m - 1][j] = True
                bfs(deque([[m - 1, j]]), atlanticVisited)

        result = []
        for i in range(m):
            for j in range(n):
                if atlanticVisited[i][j] and pacificVisited[i][j]:
                    result.append([i, j])
        return result