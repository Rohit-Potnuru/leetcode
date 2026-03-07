class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        memo = [-1] * (n * n)
        notVisited = [True] * (n * n)
        for pos in range(n * n):
            i = n - 1 - pos//n
            j = pos % n
            if i % 2 == n % 2:
                j = n - 1 - j
            
            memo[pos] = board[i][j] - 1


        q = deque()
        q.append(0)
        count = 0
        while len(q) > 0:
            size = len(q)
            count += 1
            while size > 0:
                pos = q.popleft()
                if notVisited[pos]:
                    if pos == n * n - 1:
                        return count - 1
                    for z in range(pos + 1, min(pos + 6, n * n - 1) + 1):
                        if memo[z] >= 0:
                            q.append(memo[z])
                        else:
                            q.append(z)
                notVisited[pos] = False
                size -= 1
        return -1