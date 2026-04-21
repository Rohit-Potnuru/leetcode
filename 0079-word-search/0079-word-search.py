class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backTrack(x: int, y: int, pos: int):
            if board[x][y] != word[pos] or pos == len(word) - 1:
                return board[x][y] == word[pos]

            temp = board[x][y]
            board[x][y] = "."
            ans = False
            for dx, dy in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                new_x = x + dx
                new_y = y + dy
                if 0 <= new_x < n and 0 <= new_y < m:
                    ans = ans or backTrack(new_x, new_y, pos + 1)
            board[x][y] = temp
            return ans

        n = len(board)
        m = len(board[0])
        for i in range(n):
            for j in range(m):
                if backTrack(i, j, 0):
                    return True
        return False