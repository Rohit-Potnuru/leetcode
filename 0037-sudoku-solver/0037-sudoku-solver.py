class Solution(object):
    def solveSudoku(self, board):
        m, n = 9, 9
        horizontal = [[True] * m for _ in range(n)]
        vertical = [[True] * m for _ in range(n)]
        diagonal = [[True] * m for _ in range(n)]
        self.ansBoard = [[0] * m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                self.ansBoard[i][j] = board[i][j]
                if board[i][j] != '.':
                    val = int(board[i][j]) - 1
                    horizontal[i][val] = False
                    vertical[j][val] = False
                    diagonal[(i//3) * 3 + (j//3)][val] = False
        self.solve_sudoku(0, 0, board, horizontal, vertical, diagonal)
        
        for i in range(9):
            for j in range(9):
                board[i][j] = self.ansBoard[i][j]
   
    def valid_val_sudoku(self, i, j, board, horizontal, vertical, diagonal):
        m, n = 9, 9
        valid_val = []
        for val in range(m):
            if horizontal[i][val] and vertical[j][val] and diagonal[(i//3) * 3 + (j//3)][val]:
                valid_val.append(val)
        return valid_val
        
    def solve_sudoku(self, i, j, board, horizontal, vertical, diagonal):
        if i == 9:
            print(board)
            for i in range(9):
                for j in range(9):
                    self.ansBoard[i][j] = board[i][j]
            print(self.ansBoard)
            return True
        elif j == 9:

            return self.solve_sudoku(i + 1, 0, board, horizontal, vertical, diagonal)
        if board[i][j] != '.':

            return self.solve_sudoku(i, j + 1, board, horizontal, vertical, diagonal)
        
        valid_val = self.valid_val_sudoku(i, j, board, horizontal, vertical, diagonal)
        curr = False
        for val in valid_val:
            horizontal[i][val] = False
            vertical[j][val] = False
            diagonal[(i//3) * 3 + (j//3)][val] = False
            board[i][j] = str(val + 1)
            curr = self.solve_sudoku(i, j + 1, board, horizontal, vertical, diagonal) and curr
            board[i][j] = '.'
            horizontal[i][val] = True
            vertical[j][val] = True
            diagonal[(i//3) * 3 + (j//3)][val] = True
            if(curr): 
                return True
        return curr
