class Solution(object):
    def isValidSudoku(self, board):
        m, n = 9, 9
        horizontal = [[False] * m for _ in range(n)]
        vertical = [[False] * m for _ in range(n)]
        diagonal = [[False] * m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                if board[i][j] != '.':
                    val = int(board[i][j]) - 1
                    if(horizontal[i][val]): 
                        return False
                    if(vertical[j][val]): 
                        return False
                    if(diagonal[(i//3) * 3 + (j//3)][val]):
                        return False
                    horizontal[i][val] = True
                    vertical[j][val] = True
                    diagonal[(i//3) * 3 + (j//3)][val] = True
        return True