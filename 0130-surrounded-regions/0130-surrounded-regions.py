class Solution:
    def getNeighbors(self, board: List[List[str]], i: int, j: int, m: int, n: int) -> List[List[str]]:
        neighbors = [[1, 0], [0, -1], [-1, 0], [0, 1]]
        res = []
        for di, dj in neighbors:
           new_i = i + di
           new_j = j + dj
           if 0 <= new_i < m and 0 <= new_j < n and board[new_i][new_j] == "O":
               res.append([new_i, new_j])
        return res

    def dfs(self, board: List[List[str]], i: int, j: int, m: int, n: int) -> None:
        board[i][j] = "D"
        neighbors = self.getNeighbors(board, i, j, m, n)
        for neig in neighbors:
            self.dfs(board, neig[0], neig[1], m, n)
        
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            if board[i][0] == "O":
                self.dfs(board, i, 0, m, n)
            if board[i][n - 1] == "O":
                self.dfs(board, i, n - 1, m, n)
        
        for j in range(n):
            if board[0][j] == "O":
                self.dfs(board, 0, j, m, n)
            if board[m - 1][j] == "O":
                self.dfs(board, m - 1, j, m, n)

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "D":
                    board[i][j] = "O"
        