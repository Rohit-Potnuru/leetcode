class Trie:

    def __init__(self):
        self.children = [None] * 26
        self.end = False

    def insert(self, word: str) -> None:
        curr = self
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = Trie()
            curr = curr.children[idx]
        curr.end = True

    def search(self, word: str) -> bool:
        curr = self
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                return False
            curr = curr.children[idx]
        return curr.end

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for ch in prefix:
            idx = ord(ch) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return True
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)