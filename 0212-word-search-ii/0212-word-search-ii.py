class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.end = False
        self.word = ""

    def insert(self, word):
        curr = self
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = Trie()
            curr = curr.children[idx]
        curr.end = True
        curr.word = word

class Solution:
    def dfs(self, r: int, c: int, m: int, n: int, curr: Trie):
        if self.visited[r][c] or (curr is None):
            return
        if curr.end:
            self.output.add(curr.word)

        self.visited[r][c] = True
        for dr, dc in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            new_r = r + dr
            new_c = c + dc
            if 0 <= new_r < m and 0 <= new_c < n:
                idx = ord(self.board[new_r][new_c]) - ord('a')
                self.dfs(new_r, new_c, m, n, curr.children[idx]) 
        self.visited[r][c] = False
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = Trie()
        for word in words:
            root.insert(word)

        m = len(board)
        n = len(board[0])
        self.visited = [[False] * n for _ in range(m)]
        self.output = set()
        self.board = board
        for r in range(m):
            for c in range(n):
                idx = ord(self.board[r][c]) - ord('a')
                self.dfs(r, c, m, n, root.children[idx])

        return list(self.output)