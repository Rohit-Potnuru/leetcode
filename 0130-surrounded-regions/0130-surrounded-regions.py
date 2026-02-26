class Solution:
    def dfs(self, board: List[List[str]], i: int, j: int, m: int, n: int) -> None:
        if not (0 <= i < m and 0 <= j < n) or board[i][j] != "O":
            return
        board[i][j] = "D"
        for di, dj in [[1, 0], [0, -1], [-1, 0], [0, 1]]:
            self.dfs(board, i + di, j + dj, m, n)
        
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            self.dfs(board, i, 0, m, n)
            self.dfs(board, i, n - 1, m, n)
        
        for j in range(n):
            self.dfs(board, 0, j, m, n)
            self.dfs(board, m - 1, j, m, n)

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "D":
                    board[i][j] = "O"
        