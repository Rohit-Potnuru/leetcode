class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        wordListSet = set(wordList)
        visited = set()
        q.append(beginWord)
        visited.add(beginWord)
        count = 0
        while len(q) > 0:
            count += 1
            size = len(q)
            while size > 0:
                word = q.popleft()
                if word == endWord:
                    return count
                for i in range(len(word)):
                    for ch in range(26):
                        newWord = word[:i] + chr(ord('a') + ch) + word[i + 1:]
                        if newWord in wordListSet and newWord not in visited:
                            visited.add(newWord)
                            q.append(newWord)
                size -= 1
        return 0